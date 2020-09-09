package com.gan.wcare.ejb.model;

public class LoginInfo {

    //Input
    String loginId;
    String password;

    //Output
    boolean validLogin = false;
    boolean userRoleBuisnessManager = false;
    boolean userRoleWealthManager = false;
    boolean userRoleCustomer = false;
    String returnCode;
    String returnMessage;

    String userRole;
    String userLoginName;
    String userLoginEmailId;
    String userDisplayId;
    String userDisplayName;

    public void clear() {
        validLogin = false;
        userRoleBuisnessManager = false;
        userRoleWealthManager = false;
        userRoleCustomer = false;
        returnCode = null;
        returnMessage = null;

        userRole = null;
        userLoginName = null;
        userLoginEmailId = null;
        userDisplayId = null;
        userDisplayName = null;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidLogin() {
        return validLogin;
    }

    public void setValidLogin(boolean validLogin) {
        this.validLogin = validLogin;
    }

    public boolean isUserRoleBuisnessManager() {
        return userRoleBuisnessManager;
    }

    public void setUserRoleBuisnessManager(boolean userRoleBuisnessManager) {
        this.userRoleBuisnessManager = userRoleBuisnessManager;
    }

    public boolean isUserRoleWealthManager() {
        return userRoleWealthManager;
    }

    public void setUserRoleWealthManager(boolean userRoleWealthManager) {
        this.userRoleWealthManager = userRoleWealthManager;
    }

    public boolean isUserRoleCustomer() {
        return userRoleCustomer;
    }

    public void setUserRoleCustomer(boolean userRoleCustomer) {
        this.userRoleCustomer = userRoleCustomer;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserLoginEmailId() {
        return userLoginEmailId;
    }

    public void setUserLoginEmailId(String userLoginEmailId) {
        this.userLoginEmailId = userLoginEmailId;
    }

    public String getUserDisplayId() {
        return userDisplayId;
    }

    public void setUserDisplayId(String userDisplayId) {
        this.userDisplayId = userDisplayId;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
