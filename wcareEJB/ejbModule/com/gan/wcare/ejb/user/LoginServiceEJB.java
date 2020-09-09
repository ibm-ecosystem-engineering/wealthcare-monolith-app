package com.gan.wcare.ejb.user;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.common.LoginUtil;
import com.gan.wcare.ejb.model.LoginInfo;
import com.gan.wcare.jpa.dao.WcBusinessManagerDao;
import com.gan.wcare.jpa.dao.WcCustomerDao;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.dao.WcWealthManagerDao;
import com.gan.wcare.jpa.entity.WcBusinessManager;
import com.gan.wcare.jpa.entity.WcCustomer;
import com.gan.wcare.jpa.entity.WcUsers;
import com.gan.wcare.jpa.entity.WcWealthManager;

@Stateless
public class LoginServiceEJB {

    @EJB
    private WcUsersEJB usersService;

	WcUsersDao wcUsersDao = new WcUsersDao();;
	WcCustomerDao wcCustomerDao = new WcCustomerDao();;
	WcBusinessManagerDao wcBusinessManagerDao = new WcBusinessManagerDao();
	WcWealthManagerDao wcWealthManagerDao = new WcWealthManagerDao();

	
    public void processLogin (LoginInfo loginInfo) {
        LogUtil.log("LoginService : doLogin started : " + loginInfo.getLoginId());

        loginInfo.clear();

        WcUsers wcUsers = usersService.fetchUserByLoginId(loginInfo.getLoginId());

        if (wcUsers == null) {
            LogUtil.log("LoginService : login failed : User doesn't exists");
            populateReturnCode (loginInfo, CommonConstants.LOGIN_RETURN_CODE_400, CommonConstants.LOGIN_RETURN_MSG_Invalid_LoginId);
        } else {
            if (LoginUtil.match(loginInfo.getPassword(), wcUsers.getPassword())) {
                LogUtil.log("LoginService : login success");
                populateReturnCode (loginInfo, CommonConstants.LOGIN_RETURN_CODE_200, CommonConstants.LOGIN_RETURN_MSG_Sucess);

                //Process
                processLoginSuccess(loginInfo, wcUsers);
            } else {
                LogUtil.log("LoginService : login failed : Invalid password");
                populateReturnCode (loginInfo, CommonConstants.LOGIN_RETURN_CODE_401, CommonConstants.LOGIN_RETURN_MSG_Invalid_Password);
            }
        }
    }

    private void processLoginSuccess(LoginInfo loginInfo, WcUsers wcUsers) {
        LoginUtil.populateRole(wcUsers.getRole(), loginInfo);

        loginInfo.setUserLoginEmailId(wcUsers.getEmailId());
        loginInfo.setUserLoginName(wcUsers.getUserName());
        loginInfo.setUserRole(wcUsers.getRole());

        if (loginInfo.isUserRoleCustomer()) {
            populateCustomer(loginInfo, wcUsers);
        } else if (loginInfo.isUserRoleBuisnessManager()) {
            populateBusinessManager(loginInfo, wcUsers);
        } else if (loginInfo.isUserRoleWealthManager()) {
            populateWealthManager(loginInfo, wcUsers);
        }
    }

    private void populateCustomer(LoginInfo loginInfo, WcUsers wcUsers) {
        WcCustomer entity = wcCustomerDao.findOneByUserId(wcUsers.getId());
        if (entity == null) {
            LogUtil.log("LoginService : login failed : User/Customer doesn't exists");
            populateReturnCode (loginInfo, CommonConstants.LOGIN_RETURN_CODE_400, CommonConstants.LOGIN_RETURN_MSG_Invalid_LoginId);
        } else {
            loginInfo.setUserDisplayId(String.valueOf(entity.getId()));
            loginInfo.setUserDisplayName(entity.getFirstName() + " " + entity.getLastName());

            loginInfo.setValidLogin(true);
        }
    }

    private void populateWealthManager(LoginInfo loginInfo, WcUsers wcUsers) {
        WcWealthManager entity = wcWealthManagerDao.findOneByUserId(wcUsers.getId());
        if (entity == null) {
            LogUtil.log("LoginService : login failed : User/WealthManager doesn't exists");
            populateReturnCode (loginInfo, CommonConstants.LOGIN_RETURN_CODE_400, CommonConstants.LOGIN_RETURN_MSG_Invalid_LoginId);
        } else {
            loginInfo.setUserDisplayId(String.valueOf(entity.getId()));
            loginInfo.setUserDisplayName(entity.getFirstName() + " " + entity.getLastName());

            loginInfo.setValidLogin(true);
        }
    }

    private void populateBusinessManager(LoginInfo loginInfo, WcUsers wcUsers) {
        WcBusinessManager entity = wcBusinessManagerDao.findOneByUserId(wcUsers.getId());
        if (entity == null) {
            LogUtil.log("LoginService : login failed : User/BusinessManager doesn't exists");
            populateReturnCode (loginInfo, CommonConstants.LOGIN_RETURN_CODE_400, CommonConstants.LOGIN_RETURN_MSG_Invalid_LoginId);
        } else {
            loginInfo.setUserDisplayId(String.valueOf(entity.getId()));
            loginInfo.setUserDisplayName(entity.getFirstName() + " " + entity.getLastName());

            loginInfo.setValidLogin(true);
        }
    }

    private void populateReturnCode(LoginInfo loginInfo, String returnCode, String returnMessage) {
        loginInfo.setReturnCode(returnCode);
        loginInfo.setReturnMessage(returnMessage);
    }
	
}
