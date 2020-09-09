package com.gan.wcare.ejb.model;


public class InvestmentInfo {

    private int id;
    private int wcGoalId;

    private String investmentDate;

    private String investmentAmount;

    private String stockAmount;
    private String mutualFundAmount;
    private String fixedDepositAmount;

    private double currentValueStockAmount;
    private double currentValueMutualFundAmount;
    private double currentValueFixedDepositAmount;

    private String currentValueStockAmountString;
    private String currentValueMutualFundAmountString;
    private String currentValueFixedDepositAmountString;

    private String currentValueStockAmountUpDown;
    private String currentValueMutualFundAmountUpDown;
    private String currentValueFixedDepositAmountUpDown;

    private double currentValueTotal;
    private String currentValueTotalString;
    private String currentValueTotalComments;
    private String currentValueTotalUpDown;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWcGoalId() {
        return wcGoalId;
    }

    public void setWcGoalId(int wcGoalId) {
        this.wcGoalId = wcGoalId;
    }

    public String getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(String investmentDate) {
        this.investmentDate = investmentDate;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(String stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getMutualFundAmount() {
        return mutualFundAmount;
    }

    public void setMutualFundAmount(String mutualFundAmount) {
        this.mutualFundAmount = mutualFundAmount;
    }

    public String getFixedDepositAmount() {
        return fixedDepositAmount;
    }

    public void setFixedDepositAmount(String fixedDepositAmount) {
        this.fixedDepositAmount = fixedDepositAmount;
    }

    public double getCurrentValueStockAmount() {
        return currentValueStockAmount;
    }

    public void setCurrentValueStockAmount(double currentValueStockAmount) {
        this.currentValueStockAmount = currentValueStockAmount;
    }

    public double getCurrentValueMutualFundAmount() {
        return currentValueMutualFundAmount;
    }

    public void setCurrentValueMutualFundAmount(double currentValueMutualFundAmount) {
        this.currentValueMutualFundAmount = currentValueMutualFundAmount;
    }

    public double getCurrentValueFixedDepositAmount() {
        return currentValueFixedDepositAmount;
    }

    public void setCurrentValueFixedDepositAmount(double currentValueFixedDepositAmount) {
        this.currentValueFixedDepositAmount = currentValueFixedDepositAmount;
    }

    public String getCurrentValueStockAmountString() {
        return currentValueStockAmountString;
    }

    public void setCurrentValueStockAmountString(String currentValueStockAmountString) {
        this.currentValueStockAmountString = currentValueStockAmountString;
    }

    public String getCurrentValueMutualFundAmountString() {
        return currentValueMutualFundAmountString;
    }

    public void setCurrentValueMutualFundAmountString(String currentValueMutualFundAmountString) {
        this.currentValueMutualFundAmountString = currentValueMutualFundAmountString;
    }

    public String getCurrentValueFixedDepositAmountString() {
        return currentValueFixedDepositAmountString;
    }

    public void setCurrentValueFixedDepositAmountString(String currentValueFixedDepositAmountString) {
        this.currentValueFixedDepositAmountString = currentValueFixedDepositAmountString;
    }

    public double getCurrentValueTotal() {
        return currentValueTotal;
    }

    public void setCurrentValueTotal(double currentValueTotal) {
        this.currentValueTotal = currentValueTotal;
    }

    public String getCurrentValueTotalString() {
        return currentValueTotalString;
    }

    public void setCurrentValueTotalString(String currentValueTotalString) {
        this.currentValueTotalString = currentValueTotalString;
    }

    public String getCurrentValueTotalComments() {
        return currentValueTotalComments;
    }

    public void setCurrentValueTotalComments(String currentValueTotalComments) {
        this.currentValueTotalComments = currentValueTotalComments;
    }

    public String getCurrentValueStockAmountUpDown() {
        return currentValueStockAmountUpDown;
    }

    public void setCurrentValueStockAmountUpDown(String currentValueStockAmountUpDown) {
        this.currentValueStockAmountUpDown = currentValueStockAmountUpDown;
    }

    public String getCurrentValueMutualFundAmountUpDown() {
        return currentValueMutualFundAmountUpDown;
    }

    public void setCurrentValueMutualFundAmountUpDown(String currentValueMutualFundAmountUpDown) {
        this.currentValueMutualFundAmountUpDown = currentValueMutualFundAmountUpDown;
    }

    public String getCurrentValueFixedDepositAmountUpDown() {
        return currentValueFixedDepositAmountUpDown;
    }

    public void setCurrentValueFixedDepositAmountUpDown(String currentValueFixedDepositAmountUpDown) {
        this.currentValueFixedDepositAmountUpDown = currentValueFixedDepositAmountUpDown;
    }

    public String getCurrentValueTotalUpDown() {
        return currentValueTotalUpDown;
    }

    public void setCurrentValueTotalUpDown(String currentValueTotalUpDown) {
        this.currentValueTotalUpDown = currentValueTotalUpDown;
    }
}

