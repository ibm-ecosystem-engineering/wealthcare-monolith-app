package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.DateUtil;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.jpa.dao.WcWealthManagerDao;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.dao.WcWealthManagerDao;
import com.gan.wcare.jpa.entity.WcWealthManager;
import com.gan.wcare.jpa.entity.WcUsers;
import com.gan.wcare.jpa.entity.WcWealthManager;

@Stateless
public class WcWealthManagerEJB {

	WcUsersDao wcUsersDao = new WcUsersDao();
	WcWealthManagerDao wcWealthManagerDao = new WcWealthManagerDao();
    WcWealthManagerDao  wealthManagerDao  = new WcWealthManagerDao();
	

    @EJB
    private WcUsersEJB usersService;
    @EJB
    private ImageServiceEJB imageService;
 

    public List<WcWealthManager> findAll() {
        List<WcWealthManager> list = wealthManagerDao.findAll();
        
        for (WcWealthManager wcWealthManager : list) {
        	wcWealthManager.setStartDateString(DateUtil.convertMMMYYY(wcWealthManager.getStartDate()));
        	wcWealthManager.setImage(imageService.createImageUrl(wcWealthManager.getGender(), wcWealthManager.getId(), true));
        }
        
        return list;
    }

    public Object create(WcWealthManager wcWealthManager) {
        Object result;

        LogUtil.log("WcWealthManagerService : create : " + wcWealthManager.getEmailId());

        //Create User
        WcUsers wcUsers = new WcUsers(wcWealthManager.getEmailId(), "wc", wcWealthManager.getEmailId(), CommonConstants.ROLE_WEALTH_MANAGER);

        result = usersService.create(wcUsers);

        if (result instanceof CustomError) {
            LogUtil.log("WcWealthManagerService : User not created");
        } else {
            //Copy the userId from the newly created entity
            wcUsers = (WcUsers) result;
            wcWealthManager.setWcUserId(wcUsers.getId());

            //Create Customer
            wcWealthManagerDao.save(wcWealthManager);
            LogUtil.log("WcWealthManagerService : User created : " + wcUsers.getId());
            result = wcWealthManager;

            //Send MQ message
            String msg = "Hi " + wcWealthManager.getFirstName() + " !!!! \n\n" + "Your account is created. Please login with your email id " + wcWealthManager.getEmailId();
//            mQSender.sendMessageCustomer(wcWealthManager.getEmailId() , msg);
        }

        return result;
    }

    public WcWealthManager update(WcWealthManager wcWealthManager) {
        LogUtil.log("WcWealthManagerService : update : " + wcWealthManager.getId());


        wcWealthManagerDao.save(wcWealthManager);
        wcWealthManager = find(wcWealthManager.getId());
        return wcWealthManager;
    }

    public WcWealthManager find(Integer id) {
        WcWealthManager wcWealthManager = wcWealthManagerDao.findById(id);
        return wcWealthManager;
    }

    public WcWealthManager delete(int id) {

        LogUtil.log("WcWealthManagerService : delete : " + id);

        WcWealthManager wcWealthManager = find(id);
        if(wcWealthManager != null){
            wcUsersDao.delete(wcWealthManager.getWcUserId());
            wcWealthManagerDao.delete(id);
        }
        return wcWealthManager;
    }

    public WcWealthManager findOneByWcUserId(Integer id) {
        return wcWealthManagerDao.findOneByUserId(id);
    }
}
