package com.gan.wcare.ejb.model;


import java.util.List;

public class GoalInfo {

    private int id;
    private int wcCustomerId;
    private int wcWealthManagerId;

    private String goalReference;
    private String goalDesc;

    private String goalAchievementString;

    private String targetAmount;
    private String targetDate;
    private String totalInvestmentAmount;
    private String investmentCurrentValue;

    private String currency;

    private List<InvestmentInfo> investments;
    private List<Integer> completionPercentage;

    private List<GraphDataBar> graphDataBar;
    private List<GraphDataLine> graphDataLine;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWcCustomerId() {
        return wcCustomerId;
    }

    public void setWcCustomerId(int wcCustomerId) {
        this.wcCustomerId = wcCustomerId;
    }

    public int getWcWealthManagerId() {
        return wcWealthManagerId;
    }

    public void setWcWealthManagerId(int wcWealthManagerId) {
        this.wcWealthManagerId = wcWealthManagerId;
    }

    public String getGoalReference() {
        return goalReference;
    }

    public void setGoalReference(String goalReference) {
        this.goalReference = goalReference;
    }

    public String getGoalDesc() {
        return goalDesc;
    }

    public void setGoalDesc(String goalDesc) {
        this.goalDesc = goalDesc;
    }

    public String getGoalAchievementString() {
        return goalAchievementString;
    }

    public void setGoalAchievementString(String goalAchievementString) {
        this.goalAchievementString = goalAchievementString;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getTotalInvestmentAmount() {
        return totalInvestmentAmount;
    }

    public void setTotalInvestmentAmount(String totalInvestmentAmount) {
        this.totalInvestmentAmount = totalInvestmentAmount;
    }

    public String getInvestmentCurrentValue() {
        return investmentCurrentValue;
    }

    public void setInvestmentCurrentValue(String investmentCurrentValue) {
        this.investmentCurrentValue = investmentCurrentValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<InvestmentInfo> getInvestments() {
        return investments;
    }

    public void setInvestments(List<InvestmentInfo> investments) {
        this.investments = investments;
    }

    public List<Integer> getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(List<Integer> completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public List<GraphDataBar> getGraphDataBar() {
        return graphDataBar;
    }

    public void setGraphDataBar(List<GraphDataBar> graphDataBar) {
        this.graphDataBar = graphDataBar;
    }

    public List<GraphDataLine> getGraphDataLine() {
        return graphDataLine;
    }

    public void setGraphDataLine(List<GraphDataLine> graphDataLine) {
        this.graphDataLine = graphDataLine;
    }
}

