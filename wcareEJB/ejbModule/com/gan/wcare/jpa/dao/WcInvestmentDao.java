package com.gan.wcare.jpa.dao;

import java.util.List;

import com.gan.wcare.jpa.entity.WcInvestment;

public class WcInvestmentDao extends DaoBase{
	
	public static String findAllSql = "select a FROM WcInvestment a";
	public static String findAllByGoalIdSql = "SELECT a FROM WcInvestment a WHERE a.wcGoalId = :wcGoalId";

	public List<WcInvestment> findAll() {
        List<WcInvestment> list = findAll(findAllSql);
        return list;
    }

    public  List<WcInvestment> findAllByGoalId(int wcGoalId) {
        List<WcInvestment> list =  findAll(findAllByGoalIdSql, "wcGoalId", wcGoalId);
        return list;
    }
	
    public WcInvestment findOneByGoalId(int wcGoalId) {
        return (WcInvestment) findOne(findAllByGoalIdSql, "wcGoalId", wcGoalId);
    }

    public WcInvestment findById(int id) {
        return (WcInvestment) findById(WcInvestment.class, id);
    }

    public boolean delete(int id) {
        return delete(WcInvestment.class, id);
    }
    
    public boolean deleteByGoalId(int id) {
    	List <WcInvestment> list = findAllByGoalId(id);
    	for (WcInvestment wcInvestment : list) {
    		delete(WcInvestment.class, wcInvestment.getId());
    	}
        return true;
    }
    
}
