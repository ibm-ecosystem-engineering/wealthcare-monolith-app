package com.gan.wcare.jpa.dao;

import java.util.List;

import com.gan.wcare.jpa.entity.WcCustomer;

public class WcCustomerDao extends DaoBase{
	
	public static String findAllSql = "select a FROM WcCustomer a";
	public static String findOneByUserIdSql = "SELECT a FROM WcCustomer a WHERE a.wcUserId = :wcUserId";

	public List<WcCustomer> findAll() {
        List<WcCustomer> list = findAll(findAllSql);
        return list;
    }

    public WcCustomer findOneByUserId(int userId) {
        return (WcCustomer) findOne(findOneByUserIdSql, "wcUserId", userId);
    }

    public WcCustomer findById(int id) {
        return (WcCustomer) findById(WcCustomer.class, id);
    }

    public boolean delete(int id) {
        return delete(WcCustomer.class, id);
    }
    
}
