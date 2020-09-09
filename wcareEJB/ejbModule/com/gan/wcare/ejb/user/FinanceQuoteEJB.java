package com.gan.wcare.ejb.user;

import java.util.List;

import javax.ejb.Stateless;

import com.gan.wcare.common.CommonConstants;
import com.gan.wcare.common.DateUtil;
import com.gan.wcare.common.LogUtil;
import com.gan.wcare.common.NumberUtil;
import com.gan.wcare.common.StringUtil;
import com.gan.wcare.ejb.model.CustomError;
import com.gan.wcare.ejb.model.InvestmentInfo;
import com.gan.wcare.ejb.model.QuoteCacheInfo;
import com.gan.wcare.jpa.dao.WcUsersDao;
import com.gan.wcare.jpa.entity.WcInvestment;
import com.gan.wcare.jpa.entity.WcUsers;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Stateless
public class FinanceQuoteEJB {

	private String imageUrl = "https://randomuser.me/api/portraits";

    private int stockQuoteRefreshRateInSeconds = 45;

    private int mutualQuoteRefreshRateInSeconds = 45;

    Map<Integer, QuoteCacheInfo> stockQuoteCache = new HashMap();
    Map<Integer, QuoteCacheInfo> mutualQuoteCache = new HashMap();

    public double processAndReturnRandomQuote(int investmentId, double amount, long diffDays, int increaseDescreaseFactor, int quoteRefreshRateInSeconds, Map<Integer, QuoteCacheInfo> quoteCache) {
        LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote : started");

        QuoteCacheInfo quoteCacheInfo = quoteCache.get(investmentId);
        if (quoteCacheInfo == null) {
            LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote 1: ");

            quoteCacheInfo = new QuoteCacheInfo();
            quoteCacheInfo.setCreatedTimeInMilliSeconds(-10000);
            quoteCache.put(investmentId, quoteCacheInfo);
            LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote 2: ");

        }
        LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote 3: ");

        double resultAmount = 0;
        long currentTimeInMilliSeconds = System.currentTimeMillis();
        boolean timeLimitExceeded = DateUtil.isLimitExceeded(currentTimeInMilliSeconds, quoteCacheInfo.getCreatedTimeInMilliSeconds(), quoteRefreshRateInSeconds);
        LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote 4: ");

        if (timeLimitExceeded) {
            resultAmount = randomIncreaseOrDecrease(amount, diffDays, increaseDescreaseFactor);
            quoteCacheInfo.setCreatedTimeInMilliSeconds(currentTimeInMilliSeconds);
            quoteCacheInfo.setQuoteValue(resultAmount);
            LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote 5: ");

        } else {
            resultAmount = quoteCacheInfo.getQuoteValue();
            LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote 6: ");

        }
        LogUtil.logDebug("FinanceQuoteService : processAndReturnRandomQuote resultAmount: " + resultAmount);

        return resultAmount;
    }

    public double randomIncreaseOrDecrease(double amount, long diffDays, int increaseRandomCheck) {
        LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease : started");
        LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease : amount : " + amount);
        LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease : diffDays : " + diffDays);
        LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease : increaseRandomCheck : " + increaseRandomCheck);

        double resultAmount = 0;
        if (diffDays <= 1) {
            resultAmount = amount;
        } else {
            int randomValue = random(100);
            boolean increase = randomValue > increaseRandomCheck;
            if (increase) {
                int maxRandomValue = (int) (diffDays / 365) + 1 ;
                maxRandomValue = maxRandomValue * 100;
                randomValue = random( (int) maxRandomValue);
                resultAmount = amount + (amount * ((double)randomValue/100.0));

                LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease increase: maxRandomValue : " + maxRandomValue);
                LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease increase: randomValue : " + randomValue);

            } else {
                randomValue = random(100);
                resultAmount = amount - (amount * ((double)randomValue/100.0));
                LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease decrease: randomValue : " + randomValue);
            }
        }
        LogUtil.logDebug("FinanceQuoteService : randomIncreaseOrDecrease : resultAmount : " + resultAmount);
        return resultAmount;
    }

    public int random(int range) {
        Random rand = new Random();
        int value = rand.nextInt(range);
        return value;
    }

    public double getCurrentFD(double amount, long diffDays) {
        LogUtil.logDebug("FinanceQuoteService : getCurrentFD : started");
        LogUtil.logDebug("FinanceQuoteService : getCurrentFD : diffDays : " + diffDays);

        if (diffDays <= 0) {
            diffDays = 1;
        }
        double increasePercentage = NumberUtil.percentage(365, 0.12, diffDays);
        double result = amount + (amount * increasePercentage);

        LogUtil.logDebug("FinanceQuoteService : getCurrentFD : increasePercentage : " + increasePercentage);
        LogUtil.logDebug("FinanceQuoteService : getCurrentFD : amount : " + amount);
        LogUtil.logDebug("FinanceQuoteService : getCurrentFD : result : " + result);

        return result;
    }

    public void populateCurrentQuote(WcInvestment wcInvestment, InvestmentInfo investmentInfo) {
        LogUtil.logDebug("FinanceQuoteService : populateCurrentQuote : started");

        int investmentId = wcInvestment.getId();
        double amount = wcInvestment.getStockAmount();
        long diffDays = DateUtil.dateDiffInDays(new Date(), wcInvestment.getInvestmentDate());

        LogUtil.logDebug("FinanceQuoteService : populateCurrentQuote : investmentId : " + investmentId);
        LogUtil.logDebug("FinanceQuoteService : populateCurrentQuote : diffDays : " + diffDays);
        LogUtil.logDebug("FinanceQuoteService : populateCurrentQuote : amount : " + amount);

        double currStockAmount = processAndReturnRandomQuote(investmentId, wcInvestment.getStockAmount(), diffDays, 15,  stockQuoteRefreshRateInSeconds, stockQuoteCache);
        double currMutualFundAmount = processAndReturnRandomQuote(investmentId, wcInvestment.getMutualFundAmount(), diffDays, 5,  mutualQuoteRefreshRateInSeconds, mutualQuoteCache);
        double currFdAmount = getCurrentFD(wcInvestment.getFixedDepositAmount(), diffDays);

        double currTotalAmount = currStockAmount + currMutualFundAmount + currFdAmount;
        int totalPercentageDifference = NumberUtil.percentageIncrease(wcInvestment.getInvestmentAmount(), currTotalAmount);

        String comments;
        String upDown;
        if (totalPercentageDifference > 0) {
            comments = "( " + totalPercentageDifference + " % up )";
            upDown = "Up";
        } else if (totalPercentageDifference == 0) {
            comments = "";
            upDown = "Up";
        } else {
            comments = "( " + (totalPercentageDifference * -1) + " % down )";
            upDown = "Down";
        }

        investmentInfo.setCurrentValueTotalComments(comments);
        investmentInfo.setCurrentValueTotalUpDown(upDown);

        investmentInfo.setCurrentValueStockAmount(currStockAmount);
        investmentInfo.setCurrentValueMutualFundAmount(currMutualFundAmount);
        investmentInfo.setCurrentValueFixedDepositAmount(currFdAmount);
        investmentInfo.setCurrentValueTotal(currTotalAmount);

        investmentInfo.setCurrentValueStockAmountString((String.valueOf((long) currStockAmount)));
        investmentInfo.setCurrentValueMutualFundAmountString((String.valueOf((long) currMutualFundAmount)));
        investmentInfo.setCurrentValueFixedDepositAmountString((String.valueOf((long) currFdAmount)));
        investmentInfo.setCurrentValueTotalString((String.valueOf((long) currTotalAmount)));



        if (currStockAmount >= wcInvestment.getStockAmount()) {
            investmentInfo.setCurrentValueStockAmountUpDown("Up");
        } else {
            investmentInfo.setCurrentValueStockAmountUpDown("Down");
        }
        if (currMutualFundAmount >= wcInvestment.getMutualFundAmount()) {
            investmentInfo.setCurrentValueMutualFundAmountUpDown("Up");
        } else {
            investmentInfo.setCurrentValueMutualFundAmountUpDown("Down");
        }
        if (currFdAmount >= wcInvestment.getFixedDepositAmount()) {
            investmentInfo.setCurrentValueFixedDepositAmountUpDown("Up");
        } else {
            investmentInfo.setCurrentValueFixedDepositAmountUpDown("Down");
        }

        LogUtil.logDebug("FinanceQuoteService : populateCurrentQuote : completed");
    }
	
}
