package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import com.gan.wcare.common.LogUtil;

import com.gan.wcare.jpa.dao.WcInvestmentDao;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.entity.WcInvestment;


@Stateless
public class WcInvestmentEJB {

	WcUsersDao wcUsersDao = new WcUsersDao();
	WcInvestmentDao wcInvestmentDao = new WcInvestmentDao();
    WcInvestmentDao  wealthManagerDao  = new WcInvestmentDao();
	

    @EJB
    private WcUsersEJB usersService;
    @EJB
    private ImageServiceEJB imageService;
 
    @EJB
    private FinancialPlannerEJB financialPlannerService;
    
    public List<WcInvestment> findAll() {
        List<WcInvestment> list = wealthManagerDao.findAll();
     
        return list;
    }

    public Object create(WcInvestment wcInvestment) {

        LogUtil.log("WcInvestmentService : create" );

        financialPlannerService.populateFP(wcInvestment, wcInvestment.getInvestmentAmount());
        
            //Create Customer
            wcInvestmentDao.save(wcInvestment);

        return wcInvestment;
    }

    public WcInvestment update(WcInvestment wcInvestment) {
        LogUtil.log("WcInvestmentService : update : " + wcInvestment.getId());


        wcInvestmentDao.save(wcInvestment);
        wcInvestment = find(wcInvestment.getId());
        return wcInvestment;
    }

    public WcInvestment find(Integer id) {
        WcInvestment wcInvestment = wcInvestmentDao.findById(id);
        return wcInvestment;
    }

    public boolean delete(int id) {

        LogUtil.log("WcInvestmentService : delete : " + id);
        wcInvestmentDao.delete(id);
        return true;
    }

}
