package com.vimensa.trans_ords.model;

public class TransOrd {
    private String id;
    private String originLongitude;
    private String originLatitude;
    private String desLongitude;
    private String desLatitude;

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

    /**
     * get origin coordinate in form = latitude %2C + longitude
     * */
    public String getOriginCoord(){
        return getOriginLatitude()+"%2C-"+getOriginLongitude();
    }

    /**
     * get destination coordinate in form = latitude %2C + longitude
     * */
    public String getDesCoord(){
        return getDesLatitude()+"%2C-"+getDesLongitude();
    }
}
