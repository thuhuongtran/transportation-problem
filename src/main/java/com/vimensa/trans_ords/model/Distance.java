package com.vimensa.trans_ords.model;

public class Distance {
    private String txtDis;
    private String valueDis;
    private String txtTime;
    private String valueTime;

    public Distance() {
    }

    public Distance(String txtDis, String valueDis, String txtTime, String valueTime) {
        this.txtDis = txtDis;
        this.valueDis = valueDis;
        this.txtTime = txtTime;
        this.valueTime = valueTime;
    }

    public String getTxtDis() {
        return txtDis;
    }

    public void setTxtDis(String txtDis) {
        this.txtDis = txtDis;
    }

    public String getValueDis() {
        return valueDis;
    }

    public void setValueDis(String valueDis) {
        this.valueDis = valueDis;
    }

    public String getTxtTime() {
        return txtTime;
    }

    public void setTxtTime(String txtTime) {
        this.txtTime = txtTime;
    }

    public String getValueTime() {
        return valueTime;
    }

    public void setValueTime(String valueTime) {
        this.valueTime = valueTime;
    }
}
