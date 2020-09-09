package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.entity.WcUsers;

@Stateless
public class WcUsersEJB {

	WcUsersDao wcUsersDao = new WcUsersDao();;
	
    public List<WcUsers> findAll() {
        List<WcUsers> list = (List<WcUsers> ) wcUsersDao.findAll();
        return list;
    }

    public Object create(WcUsers entity) {
        LogUtil.log("WcUsersService : create started : " + entity.getEmailId());

        Object result = null;

        if (findByEmail(entity.getEmailId()) != null) {
            LogUtil.log("WcUsersService : Email Already exist " + entity.getEmailId());
            result = new CustomError("user with username " + entity.getEmailId() + "already exist ");
        } else {
            if (entity.getRole() == null || entity.getRole().isEmpty()) {
                entity.setRole(CommonConstants.ROLE_CUSTOMER);
            }
            wcUsersDao.save(entity);
            LogUtil.log("WcUsersService : User created : " + entity.getId());
            result = entity;
        }

        LogUtil.log("WcUsersService : create completed");
        return result;
    }

    public WcUsers update(WcUsers wcUsers) {

        LogUtil.log("WcUsersService : update : " + wcUsers.getId());

        wcUsersDao.save(wcUsers);
        wcUsers = find(wcUsers.getId());
        return wcUsers;
    }

    public WcUsers update(int id, String emailId) {

        LogUtil.log("WcUsersService : update : " + id);

        WcUsers wcUsers = find(id);
        wcUsers.setEmailId(emailId);
        return update(wcUsers);
    }

    public WcUsers findByEmail(String email) {
        return wcUsersDao.findOneByEmailId(email);
    }

    public WcUsers findByUserName(String email) {
        return wcUsersDao.findOneByUserName(email);
    }

    public WcUsers find(Integer id) {
        return wcUsersDao.findById(id);
    }

    public boolean delete(int id) {
        return wcUsersDao.delete(id);
    }


    public WcUsers fetchUserByLoginId(String loginId) {
        LogUtil.log("WcUsersEJB : fetchUserByLoginId started : " + loginId);

        WcUsers entity = findByEmail(loginId);
        if (entity == null) {
            LogUtil.log("WcUsersEJB : fetchUserByLoginId : login id doesn't match with email ids ");
            entity = findByUserName(loginId);
            if (entity == null) {
                LogUtil.log("WcUsersEJB : fetchUserByLoginId : login id doesn't match with user name as well");
            } else {
                LogUtil.log("WcUsersEJB : fetchUserByLoginId : login id match with user name ");
            }
        } else {
            LogUtil.log("WcUsersEJB : fetchUserByLoginId : login id match with email id ");
        }
        LogUtil.log("WcUsersEJB : create completed");
        return entity;
    }
	
}
