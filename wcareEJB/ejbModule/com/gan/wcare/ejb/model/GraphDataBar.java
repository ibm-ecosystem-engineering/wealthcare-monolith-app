package com.gan.wcare.ejb.model;


import java.util.ArrayList;
import java.util.List;

public class GraphDataBar {

    private List<Long> data = new ArrayList();

    private String label;

    public GraphDataBar(double stock, double mutual, double fd, String label) {
        this.data.add((long)stock);
        this.data.add((long)mutual);
        this.data.add((long)fd);
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
