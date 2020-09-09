package com.gan.wcare.common;

import com.gan.wcare.ejb.model.LoginInfo;

public class LoginUtil {
  public static boolean match(String text1, String text2) {
        boolean result = false;

        if (text1 != null && text2 != null) {
            result = text1.equalsIgnoreCase(text2);
        }
        return result;
    }

    public static String encrypt(String text) {
        String result = text;
        return result;
    }

    public static void populateRole(String role, LoginInfo loginInfo) {
        if (CommonConstants.ROLE_CUSTOMER.equalsIgnoreCase(role)) {
            loginInfo.setUserRoleCustomer(true);
        } else if (CommonConstants.ROLE_WEALTH_MANAGER.equalsIgnoreCase(role)) {
            loginInfo.setUserRoleWealthManager(true);
        } else if (CommonConstants.ROLE_BUSINESS_MANAGER.equalsIgnoreCase(role)) {
            loginInfo.setUserRoleBuisnessManager(true);
        } else {
            loginInfo.setUserRoleCustomer(true);
        }
    }

}
