package com.vimensa.trans_ords.model;

public class Shipper {
    private String id;
    private String name;
    private String longitude;
    private String latitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * get coordinate in form = latitude + %2C( to distinguish with longitude ) + longitude
     * used when call google map api
     * */
    public String getCoordinate(){

        return getLatitude()+"%2C-"+getLongitude();
    }
}
