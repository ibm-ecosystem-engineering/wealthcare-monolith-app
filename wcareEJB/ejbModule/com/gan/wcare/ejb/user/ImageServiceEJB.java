package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.common.NumberUtil;
import com.gan.wcare.common.StringUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.entity.WcUsers;

@Stateless
public class ImageServiceEJB {

	private String imageUrl = "https://randomuser.me/api/portraits";

    public String createImageUrl(String gender, int userId, boolean customer) {

        String result = imageUrl;
        if (StringUtil.isEqualsIgnoreCase(gender, "male")) {
            result = result + "/" + "men" + "/";
        } else {
            result = result + "/" + "women" + "/";
        }

        String last2Char = StringUtil.getLastChar(String.valueOf(userId), 2);
        int addFactor = 0;
        if (customer) {
            addFactor = 50;
        }
        result = result + NumberUtil.add(last2Char, addFactor);
        result = result + ".jpg";

        return result;
    }
	
}
