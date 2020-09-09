package com.gan.wcare.ejb.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.DateUtil;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.common.NumberUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.ejb.model.GoalInfo;
import com.gan.wcare.ejb.model.GoalTotalData;
import com.gan.wcare.ejb.model.GraphDataBar;
import com.gan.wcare.ejb.model.GraphDataLine;
import com.gan.wcare.ejb.model.InvestmentInfo;
import com.gan.wcare.jpa.dao.WcGoalDao;
import com.gan.wcare.jpa.dao.WcInvestmentDao;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.dao.WcGoalDao;
import com.gan.wcare.jpa.entity.WcGoal;
import com.gan.wcare.jpa.entity.WcInvestment;
import com.gan.wcare.jpa.entity.WcUsers;
import com.gan.wcare.jpa.entity.WcGoal;

@Stateless
public class WcGoalEJB {

	WcUsersDao wcUsersDao = new WcUsersDao();
	WcGoalDao wcGoalDao = new WcGoalDao();
    WcGoalDao  wealthManagerDao  = new WcGoalDao();
    WcInvestmentDao wcInvestmentDao = new WcInvestmentDao();
    
    


    @EJB
    private WcUsersEJB usersService;
    @EJB
    private ImageServiceEJB imageService;
     @EJB
    private FinanceQuoteEJB financeQuoteEJB;
    
    public List<WcGoal> findAll() {
        List<WcGoal> list = wealthManagerDao.findAll();
        return list;
    }

    public Object create(WcGoal entity) {

    	LogUtil.log("WcGoalService : create : " + entity.getGoalReference());
        
        //Set startDate
        entity.setStartDate(new Date());

        //Create Goal
        wcGoalDao.save(entity);
        
        //Send MQ message
        String msg = "A financial plan with the goal " + entity.getGoalReference() + " : " + entity.getGoalDesc() + " has been created for the customer : " + entity.getWcCustomerId();
//        mQSender.sendMessage(entity.getWcCustomerId() + "" , msg);
        
        return entity;
    }

    public WcGoal update(WcGoal wcGoal) {
        LogUtil.log("WcGoalService : update : " + wcGoal.getId());

        wcGoalDao.save(wcGoal);
        wcGoal = find(wcGoal.getId());
        return wcGoal;
    }

    public WcGoal find(Integer id) {
        WcGoal wcGoal = wcGoalDao.findById(id);
        return wcGoal;
    }

    public WcGoal delete(int id) {

        LogUtil.log("WcGoalService : delete : " + id);

        WcGoal wcGoal = find(id);
        if(wcGoal != null){
        	wcInvestmentDao.deleteByGoalId(id);
            wcGoalDao.delete(id);
        }
        return wcGoal;
    }

    public WcGoal findOneBlId(Integer id) {
        return wcGoalDao.findById(id);
    }
    
    
    public List<GoalInfo> findInfoListByCustomerId(Integer wcCustomerId) {
        List<GoalInfo> list = new ArrayList();
        GoalTotalData goalTotalData2 = new GoalTotalData();

        List<WcGoal> wcGoalList  = wcGoalDao.findAllByCustomerId(wcCustomerId);
        
        for (WcGoal wcGoal : wcGoalList) {
            List<WcInvestment> investments  = wcInvestmentDao.findAllByGoalId(wcGoal.getId());
            list.add(createGoalInfo(wcGoal, investments, goalTotalData2));
        }


        List<GraphDataBar> globalListBar = createGraphDataBar(goalTotalData2);
        List<GraphDataLine> globalListLine = createGraphDataLine(goalTotalData2);

        List<Object> resultList = new ArrayList<>();
        resultList.add(list);
        resultList.add(globalListBar);
        resultList.add(globalListLine);

        return list;
    }

    public GoalInfo findInfo(Integer id) {
        WcGoal wcGoal = wcGoalDao.findById(id);

        List<WcInvestment> investments = wcInvestmentDao.findAllByGoalId(wcGoal.getId());

        System.out.println("findInfo investments.size--> "+ investments.size());

        GoalInfo goalInfo = createGoalInfo(wcGoal, investments, null);
        return goalInfo;
    }

    

    public GoalInfo createGoalInfo(WcGoal wcGoal, List<WcInvestment> investments, GoalTotalData goalTotalData2) {
        InvestmentInfo investmentInfo;
        List<InvestmentInfo> list = new ArrayList<>();

        GoalInfo goalInfo = new GoalInfo();
        goalInfo.setInvestments(list);

        goalInfo.setId(wcGoal.getId());
        goalInfo.setWcCustomerId(wcGoal.getWcCustomerId());
        goalInfo.setWcWealthManagerId(wcGoal.getWcWealthManagerId());
        goalInfo.setGoalReference(wcGoal.getGoalReference());
        goalInfo.setGoalDesc(wcGoal.getGoalDesc());

        goalInfo.setTargetAmount(String.valueOf((long)wcGoal.getTargetAmount()));
        goalInfo.setTargetDate(DateUtil.convertMMMYYY(wcGoal.getTargetDate()));

        double totalInvestmentAmount = 0;
        double totalCurrentValue = 0;

        GoalTotalData goalTotalData = new GoalTotalData();

        for (WcInvestment wcInvestment : investments) {
            investmentInfo = createInvestmentInfo(goalInfo, wcInvestment, goalTotalData, goalTotalData2);
            list.add(investmentInfo);

            totalInvestmentAmount += wcInvestment.getInvestmentAmount();
            totalCurrentValue +=  investmentInfo.getCurrentValueTotal();
        }

        populateGoalInfo(goalInfo, totalInvestmentAmount, totalCurrentValue, wcGoal.getTargetAmount(), wcGoal.getStartDate(), wcGoal.getTargetDate());

        goalInfo.setGraphDataBar(createGraphDataBar(goalTotalData));
        goalInfo.setGraphDataLine(createGraphDataLine(goalTotalData));

        return goalInfo;
    }

    public InvestmentInfo createInvestmentInfo(GoalInfo goalInfo, WcInvestment wcInvestment, GoalTotalData goalTotalData, GoalTotalData goalTotalData2) {
        InvestmentInfo investmentInfo = new InvestmentInfo();

        investmentInfo.setId(wcInvestment.getId());
        investmentInfo.setWcGoalId(goalInfo.getId());
        investmentInfo.setInvestmentDate(DateUtil.convertDDMMMYYY(wcInvestment.getInvestmentDate()));
        investmentInfo.setInvestmentAmount(String.valueOf((long)wcInvestment.getInvestmentAmount()));

        investmentInfo.setStockAmount((String.valueOf((long)wcInvestment.getStockAmount())));
        investmentInfo.setMutualFundAmount((String.valueOf((long)wcInvestment.getMutualFundAmount())));
        investmentInfo.setFixedDepositAmount((String.valueOf((long)wcInvestment.getFixedDepositAmount())));

        //Populate Quote current and total values
        financeQuoteEJB.populateCurrentQuote(wcInvestment, investmentInfo);

        goalTotalData.addValues(wcInvestment.getStockAmount(), wcInvestment.getMutualFundAmount(), wcInvestment.getFixedDepositAmount(),
                investmentInfo.getCurrentValueStockAmount(),  investmentInfo.getCurrentValueMutualFundAmount(), investmentInfo.getCurrentValueFixedDepositAmount());

        if (goalTotalData2 != null) {
            goalTotalData2.addValues(wcInvestment.getStockAmount(), wcInvestment.getMutualFundAmount(), wcInvestment.getFixedDepositAmount(),
                    investmentInfo.getCurrentValueStockAmount(),  investmentInfo.getCurrentValueMutualFundAmount(), investmentInfo.getCurrentValueFixedDepositAmount());
        }

        return investmentInfo;
    }

    public void populateGoalInfo(GoalInfo goalInfo, double totalInvestmentAmount, double totalCurrentValue, double targetAmount, Date startDate, Date targetDate) {

        int totalPercentageDifference = NumberUtil.percentage(targetAmount, totalCurrentValue);

        int totalYears = DateUtil.dateDiffInYears(targetDate, startDate);
        int completedYears = DateUtil.dateDiffInYears(new Date(), startDate);
        String achievementString = "( "+ totalPercentageDifference + " % goal reached in " + completedYears + "/" + totalYears + " years )";

        goalInfo.setCompletionPercentage(NumberUtil.createPercentageCompletionList(totalPercentageDifference));
        goalInfo.setGoalAchievementString(achievementString);
        goalInfo.setTotalInvestmentAmount(String.valueOf((long)totalInvestmentAmount));
        goalInfo.setInvestmentCurrentValue(String.valueOf((long)totalCurrentValue));
        //TODO: To be implemented
        goalInfo.setCurrency("INR");
    }

    public List<GraphDataBar> createGraphDataBar(GoalTotalData goalTotalData) {
        List<GraphDataBar> graphDataList = new ArrayList<>();

        GraphDataBar graphData = new GraphDataBar(goalTotalData.getInitialStock(), goalTotalData.getInitialMutual(),  goalTotalData.getInitialFd(),  "Investment Amount");
        graphDataList.add(graphData);

        graphData = new GraphDataBar(goalTotalData.getCurrStock(), goalTotalData.getCurrMutual(),  goalTotalData.getCurrFd(),  "Current Amount");
        graphDataList.add(graphData);

        return graphDataList;
    }

    public List<GraphDataLine> createGraphDataLine(GoalTotalData goalTotalData) {
        List<GraphDataLine> graphDataList = new ArrayList<>();

        GraphDataLine graphData = new GraphDataLine(goalTotalData.getInitialStock(), goalTotalData.getCurrStock(), "Stock");
        graphDataList.add(graphData);

        graphData = new GraphDataLine(goalTotalData.getInitialMutual(), goalTotalData.getCurrMutual(),   "Mutual Fund");
        graphDataList.add(graphData);

        graphData = new GraphDataLine(goalTotalData.getInitialFd(), goalTotalData.getCurrFd(),   "Fixed Deposit");
        graphDataList.add(graphData);

        return graphDataList;
    }
}
