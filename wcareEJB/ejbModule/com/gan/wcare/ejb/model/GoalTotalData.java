package com.gan.wcare.ejb.model;


public class GoalTotalData {

    double currStock;
    double currMutual;
    double currFd;

    double initialStock;
    double initialMutual;
    double initialFd;

    public GoalTotalData() {
        initialStock = 0;
        initialMutual = 0;
        initialFd = 0;

        currStock = 0;
        currMutual = 0;
        currFd = 0;
    }

    public void addValues(double initialStock, double initialMutual, double initialFd, double currStock, double currMutual, double currFd) {
        this.initialStock += initialStock;
        this.initialMutual += initialMutual;
        this.initialFd += initialFd;

        this.currStock += currStock;
        this.currMutual += currMutual;
        this.currFd += currFd;
    }


    public double getCurrStock() {
        return currStock;
    }

    public void setCurrStock(double currStock) {
        this.currStock = currStock;
    }

    public double getCurrMutual() {
        return currMutual;
    }

    public void setCurrMutual(double currMutual) {
        this.currMutual = currMutual;
    }

    public double getCurrFd() {
        return currFd;
    }

    public void setCurrFd(double currFd) {
        this.currFd = currFd;
    }

    public double getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(double initialStock) {
        this.initialStock = initialStock;
    }

    public double getInitialMutual() {
        return initialMutual;
    }

    public void setInitialMutual(double initialMutual) {
        this.initialMutual = initialMutual;
    }

    public double getInitialFd() {
        return initialFd;
    }

    public void setInitialFd(double initialFd) {
        this.initialFd = initialFd;
    }
}
