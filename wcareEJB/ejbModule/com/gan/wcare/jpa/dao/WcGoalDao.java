package com.gan.wcare.jpa.dao;

import java.util.List;

import com.gan.wcare.jpa.entity.WcGoal;
import com.gan.wcare.jpa.entity.WcInvestment;

public class WcGoalDao extends DaoBase{
	
	public static String findAllSql = "select a FROM WcGoal a";
	public static String findAllByCustomerIdSql = "SELECT a FROM WcGoal a WHERE a.wcCustomerId = :wcCustomerId";

	public List<WcGoal> findAll() {
        List<WcGoal> list = findAll(findAllSql);
        return list;
    }


    public List<WcGoal> findAllByCustomerId(int wcCustomerId) {
        List<WcGoal> list =  findAll(findAllByCustomerIdSql, "wcCustomerId", wcCustomerId);
        return list;
    }
    
    public WcGoal findById(int id) {
        return (WcGoal) findById(WcGoal.class, id);
    }

    public boolean delete(int id) {
        return delete(WcGoal.class, id);
    }
    
}
