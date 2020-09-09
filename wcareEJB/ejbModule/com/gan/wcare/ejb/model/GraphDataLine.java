package com.gan.wcare.ejb.model;


import java.util.ArrayList;
import java.util.List;

public class GraphDataLine {

    private List<Long> data = new ArrayList();

    private String label;

    public GraphDataLine(double initialValue, double currentValue, String label) {
        this.data.add((long)initialValue);
        this.data.add((long)currentValue);
        this.label = label;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
