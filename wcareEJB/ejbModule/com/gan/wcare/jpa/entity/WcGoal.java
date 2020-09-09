package com.gan.wcare.jpa.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "WCGOAL")
@Entity
public class WcGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wccustomerid")
    private int wcCustomerId;

    @Column(name = "wcwealthmanagerid")
    private int wcWealthManagerId;

    @Column(name = "goalreference")
    private String goalReference;

    @Column(name = "goaldesc")
    private String goalDesc;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "targetdate")
    private Date targetDate;

    @Column(name = "targetamount")
    private double targetAmount;
//
//    @OneToMany(mappedBy = "wcGoal", fetch = FetchType.LAZY)
//    private Set<WcInvestment> investments = new HashSet<>();


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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }
}