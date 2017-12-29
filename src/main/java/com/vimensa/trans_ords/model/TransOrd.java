package com.vimensa.trans_ords.model;

public class TransOrd {
    private String id;
    private String oriName;
    private double originLongitude;
    private double originLatitude;
    private String desName;
    private double desLongitude;
    private double desLatitude;

    public TransOrd(String id, String oriName, double originLongitude,
                    double originLatitude, String desName, double desLongitude, double desLatitude) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(double originLongitude) {
        this.originLongitude = originLongitude;
    }

    public double getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(double originLatitude) {
        this.originLatitude = originLatitude;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public double getDesLongitude() {
        return desLongitude;
    }

    public void setDesLongitude(double desLongitude) {
        this.desLongitude = desLongitude;
    }

    public double getDesLatitude() {
        return desLatitude;
    }

    public void setDesLatitude(double desLatitude) {
        this.desLatitude = desLatitude;
    }
}
