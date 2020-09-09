package com.gan.wcare.ejb.model;

public class QuoteCacheInfo {

    long createdTimeInMilliSeconds;
    double quoteValue;

    public long getCreatedTimeInMilliSeconds() {
        return createdTimeInMilliSeconds;
    }

    public void setCreatedTimeInMilliSeconds(long createdTimeInMilliSeconds) {
        this.createdTimeInMilliSeconds = createdTimeInMilliSeconds;
    }

    public double getQuoteValue() {
        return quoteValue;
    }

    public void setQuoteValue(double quoteValue) {
        this.quoteValue = quoteValue;
    }
}