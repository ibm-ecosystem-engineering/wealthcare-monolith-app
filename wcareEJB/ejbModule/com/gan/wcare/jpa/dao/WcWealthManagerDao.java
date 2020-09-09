package com.gan.wcare.jpa.dao;

import java.util.List;

import com.gan.wcare.jpa.entity.WcWealthManager;

public class WcWealthManagerDao extends DaoBase{
	
	public static String findAllSql = "select a FROM WcWealthManager a";
	public static String findOneByUserIdSql = "SELECT a FROM WcWealthManager a WHERE a.wcUserId = :wcUserId";

	public List<WcWealthManager> findAll() {
        List<WcWealthManager> list = findAll(findAllSql);
        return list;
    }

    public WcWealthManager findOneByUserId(int userId) {
        return (WcWealthManager) findOne(findOneByUserIdSql, "wcUserId", userId);
    }

    public WcWealthManager findById(int id) {
        return (WcWealthManager) findById(WcWealthManager.class, id);
    }

    public boolean delete(int id) {
        return delete(WcWealthManager.class, id);
    }
    
}
