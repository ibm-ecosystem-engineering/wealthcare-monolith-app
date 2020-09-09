package com.gan.wcare.ejb.model;

public class CustomError {
    private String errorMsg;

    public CustomError(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
