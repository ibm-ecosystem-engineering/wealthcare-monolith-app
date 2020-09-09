package com.gan.wcare.jpa.dao;

import java.util.List;

import com.gan.wcare.common.LogUtil;
import com.gan.wcare.jpa.entity.WcUsers;

public class WcUsersDao extends DaoBase{
	
	public static String findAllSql = "select a FROM WcUsers a";
	public static String findOneByEmailIdSql = "SELECT a FROM WcUsers a WHERE a.emailId = :emailId";
	public static String findOneByUserNameSql = "SELECT a FROM WcUsers a WHERE a.userName = :userName";

	public List<WcUsers> findAll() {
        List<WcUsers> list = findAll(findAllSql);
        return list;
    }
	
    public WcUsers findOneByEmailId(String email) {
        return (WcUsers) findOne(findOneByEmailIdSql, "emailId", email);
    }

    public WcUsers findOneByUserName(String userName) {
    	
    	
    	Object object = findOne(findOneByUserNameSql, "userName", userName);
    	LogUtil.log("findOneByUserName 111--->" + object);
    	LogUtil.log("findOneByUserName 11111--->" + object.getClass());

    	WcUsers a = (WcUsers) object;
    	LogUtil.log("findOneByUserName 222--->" + object);
    	return a;
    	
//        return (WcUsers) findOne(findOneByUserNameSql, "userName", userName);
        
        
    }

    public WcUsers findById(Integer id) {
        return (WcUsers) findById(WcUsers.class, id);
    }

    public boolean delete(Integer id) {
        return delete(WcUsers.class, id);
    }
    
}
