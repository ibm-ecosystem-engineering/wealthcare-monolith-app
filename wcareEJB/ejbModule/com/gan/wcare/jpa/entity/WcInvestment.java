package com.gan.wcare.jpa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;


import javax.persistence.*;
import java.util.Date;

@Table(name = "WCINVESTMENT")
@Entity
public class WcInvestment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wcgoalid")
    private int wcGoalId;

    @Column(name = "investmentdate")
    private Date investmentDate;

    @Column(name = "investmentamount")
    private double investmentAmount;

    @Column(name = "stockamount")
    private double stockAmount;

    @Column(name = "mutualfundamount")
    private double mutualFundAmount;

    @Column(name = "fixeddepositamount")
    private double fixedDepositAmount;

    ///--------------------- The below information for Investment Planning with Watson

    @JsonInclude()
    @Transient
    private String gender;

    @JsonInclude()
    @Transient
    private int age;

    @JsonInclude()
    @Transient
    private double avgIncome;

    @JsonInclude()
    @Transient
    private boolean married;

    @JsonInclude()
    @Transient
    private int spouseAge;

    @JsonInclude()
    @Transient
    private double spouseAvgIncome;

    @JsonInclude()
    @Transient
    private int noOfChildren;


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

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public double getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(double stockAmount) {
        this.stockAmount = stockAmount;
    }

    public double getMutualFundAmount() {
        return mutualFundAmount;
    }

    public void setMutualFundAmount(double mutualFundAmount) {
        this.mutualFundAmount = mutualFundAmount;
    }

    public double getFixedDepositAmount() {
        return fixedDepositAmount;
    }

    public void setFixedDepositAmount(double fixedDepositAmount) {
        this.fixedDepositAmount = fixedDepositAmount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = avgIncome;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getSpouseAge() {
        return spouseAge;
    }

    public void setSpouseAge(int spouseAge) {
        this.spouseAge = spouseAge;
    }

    public double getSpouseAvgIncome() {
        return spouseAvgIncome;
    }

    public void setSpouseAvgIncome(double spouseAvgIncome) {
        this.spouseAvgIncome = spouseAvgIncome;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }
}