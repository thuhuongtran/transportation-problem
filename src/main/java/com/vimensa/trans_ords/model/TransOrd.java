package com.vimensa.trans_ords.model;

public class TransOrd {
    private String id;
    private String oriName;
    private String originLongitude;
    private String originLatitude;
    private String desName;
    private String desLongitude;
    private String desLatitude;

    public TransOrd(String id, String oriName, String originLongitude, String originLatitude,
                    String desName, String desLongitude, String desLatitude) {
        this.id = id;
        this.oriName = oriName;
        this.originLongitude = originLongitude;
        this.originLatitude = originLatitude;
        this.desName = desName;
        this.desLongitude = desLongitude;
        this.desLatitude = desLatitude;
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(String originLongitude) {
        this.originLongitude = originLongitude;
    }

    public String getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(String originLatitude) {
        this.originLatitude = originLatitude;
    }

    public String getDesLongitude() {
        return desLongitude;
    }

    public void setDesLongitude(String desLongitude) {
        this.desLongitude = desLongitude;
    }

    public String getDesLatitude() {
        return desLatitude;
    }

    public void setDesLatitude(String desLatitude) {
        this.desLatitude = desLatitude;
    }

}
