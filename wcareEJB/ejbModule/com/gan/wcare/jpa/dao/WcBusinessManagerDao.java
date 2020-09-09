package com.gan.wcare.jpa.dao;

import java.util.List;

import com.gan.wcare.jpa.entity.WcBusinessManager;


public class WcBusinessManagerDao extends DaoBase{
	
	public static String findAllSql = "select a FROM WcBusinessManager a";
	public static String findOneByUserIdSql = "SELECT a FROM WcBusinessManager a WHERE a.wcUserId = :wcUserId";

	public List<WcBusinessManager> findAll() {
        List<WcBusinessManager> list = findAll(findAllSql);
        return list;
    }

    public WcBusinessManager findOneByUserId(int userId) {
        return (WcBusinessManager) findOne(findOneByUserIdSql, "wcUserId", userId);
    }

    public WcBusinessManager findById(int id) {
        return (WcBusinessManager) findById(WcBusinessManager.class, id);
    }

    public boolean delete(int id) {
        return delete(WcBusinessManager.class, id);
    }
    
}
