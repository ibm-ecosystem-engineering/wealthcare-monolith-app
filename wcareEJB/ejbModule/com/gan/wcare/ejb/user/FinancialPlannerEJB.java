package com.gan.wcare.ejb.user;


import javax.ejb.Stateless;

import com.gan.wcare.common.LogUtil;
import com.gan.wcare.jpa.entity.WcInvestment;


import java.util.Random;

@Stateless
public class FinancialPlannerEJB {

    public void populateFP(WcInvestment wcInvestment, double investmentAmount) {

        LogUtil.log(" FinancialPlannerEJB : populateFP : started");

        //Get Stock and Mutual percentage
        Random rand = new Random();
        double stock = rand.nextInt(50);
        double mutual = rand.nextInt(50);
      

        LogUtil.log(" FinancialPlannerEJB : populateFP Before Correction S M : " + stock + "," + mutual);
        //Corrections
        if (stock < 10) {
            stock = 10;
        }
        if (mutual < 10) {
            mutual = 10;
        }
        if ((stock + mutual) >= 100) {
            stock = 20;
            mutual = 30;
        }
        LogUtil.log(" FinancialPlannerEJB : populateFP After Correction S M : " + stock + "," + mutual);


        //Identify the Financial plan
        populateFP(wcInvestment, investmentAmount, stock, mutual);

        LogUtil.log(" FinancialPlannerEJB : populateFP : completed");

    }

   
    public void populateFP(WcInvestment wcInvestment, double investmentAmount, double stock, double mutual) {
        double stockAmount = (investmentAmount *  stock) / 100;
        double mutualAmount = (investmentAmount *  mutual) / 100;
        double fdAmount = investmentAmount - (stockAmount + mutualAmount);

        wcInvestment.setStockAmount(stockAmount);
        wcInvestment.setMutualFundAmount(mutualAmount);
        wcInvestment.setFixedDepositAmount(fdAmount);

        LogUtil.log("FinancialPlannerEJB : stock : " + stock);
        LogUtil.log("FinancialPlannerEJB : mutual : " + mutual);

        LogUtil.log("FinancialPlannerEJB : investmentAmount : " + investmentAmount);
        LogUtil.log("FinancialPlannerEJB : stockAmount : " + stockAmount);
        LogUtil.log("FinancialPlannerEJB : mutualAmount : " + mutualAmount);
        LogUtil.log("FinancialPlannerEJB : fdAmount : " + fdAmount);
    }
}