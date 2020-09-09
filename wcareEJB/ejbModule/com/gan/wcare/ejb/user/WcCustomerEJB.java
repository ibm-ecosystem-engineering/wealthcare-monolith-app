package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.DateUtil;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.jpa.dao.WcCustomerDao;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.dao.WcWealthManagerDao;
import com.gan.wcare.jpa.entity.WcCustomer;
import com.gan.wcare.jpa.entity.WcUsers;
import com.gan.wcare.jpa.entity.WcWealthManager;

@Stateless
public class WcCustomerEJB {

	WcUsersDao wcUsersDao = new WcUsersDao();
	WcCustomerDao wcCustomerDao = new WcCustomerDao();
    WcWealthManagerDao  wealthManagerDao  = new WcWealthManagerDao();
	

    @EJB
    private WcUsersEJB usersService;
    @EJB
    private ImageServiceEJB imageService;
 

    public List<WcCustomer> findAll() {
        List<WcCustomer> list = wcCustomerDao.findAll();
        
        for (WcCustomer wcCustomer : list) {
        	wcCustomer.setStartDateString(DateUtil.convertMMMYYY(wcCustomer.getStartDate()));
        	wcCustomer.setImage(imageService.createImageUrl(wcCustomer.getGender(), wcCustomer.getId(), true));
            populateWealthManagerName(wcCustomer);
        }
        
        return list;
    }

    public Object create(WcCustomer wcCustomer) {
        Object result;

        LogUtil.log("WcCustomerService : create : " + wcCustomer.getEmailId());

        //Create User
        WcUsers wcUsers = new WcUsers(wcCustomer.getEmailId(), "wc", wcCustomer.getEmailId(), CommonConstants.ROLE_CUSTOMER);

        result = usersService.create(wcUsers);

        if (result instanceof CustomError) {
            LogUtil.log("WcCustomerService : User not created");
        } else {
            //Copy the userId from the newly created entity
            wcUsers = (WcUsers) result;
            wcCustomer.setWcUserId(wcUsers.getId());

            //Create Customer
            wcCustomerDao.save(wcCustomer);
            LogUtil.log("WcCustomerService : User created : " + wcUsers.getId());
            result = wcCustomer;

            //Send MQ message
            String msg = "Hi " + wcCustomer.getFirstName() + " !!! , \n\n" + "Your account is created. Please login with your email id " + wcCustomer.getEmailId();
//            mQSender.sendMessageCustomer(wcCustomer.getEmailId() , msg);
        }

        return result;
    }

    public WcCustomer update(WcCustomer wcCustomer) {
        LogUtil.log("WcCustomerService : update : " + wcCustomer.getId());

        //Update wcusers
        usersService.update(wcCustomer.getWcUserId(), wcCustomer.getEmailId());;

        wcCustomerDao.save(wcCustomer);
        wcCustomer = find(wcCustomer.getId());
        return wcCustomer;
    }

    public WcCustomer find(Integer id) {
        WcCustomer wcCustomer = wcCustomerDao.findById(id);
        populateWealthManagerName(wcCustomer);
        return wcCustomer;
    }

    private void populateWealthManagerName(WcCustomer wcCustomer) {
        String welathManagerName = "";
        if (wcCustomer.getWcWealthManagerId() > 0) {
            WcWealthManager wcWealthManager = wealthManagerDao.findById(wcCustomer.getWcWealthManagerId());
            if (wcWealthManager != null) {
                welathManagerName = wcWealthManager.getFirstName() + " " + wcWealthManager.getLastName();
            }
            wcCustomer.setWealthManagerName(welathManagerName);
        }
    }

    public WcCustomer delete(int id) {

        LogUtil.log("WcCustomerService : delete : " + id);

        WcCustomer wcCustomer = find(id);
        if(wcCustomer != null){
            wcUsersDao.delete(wcCustomer.getWcUserId());
            wcCustomerDao.delete(id);
        }
        return wcCustomer;
    }

    public WcCustomer findOneByWcUserId(Integer id) {
        return wcCustomerDao.findOneByUserId(id);
    }
}
