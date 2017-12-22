package com.vimensa.trans_ords.model;

import java.util.List;

public class ShipperManager {
    /**
     * get string of shipper coordinate of locations
     * param: List of shipper - get from json file
     * */
    public String getShipperLocationLi(List<Shipper> shipperLi){

        String shipperLoc = "";
        for (int i = 0; i < shipperLi.size(); i++) {
            if (i == shipperLi.size() - 1) {
                shipperLoc = shipperLoc + shipperLi.get(i).getLatitude() + "%2C" + shipperLi.get(i).getLongitude();
            }
            else{
                shipperLoc = shipperLoc + shipperLi.get(i).getLatitude() + "%2C" + shipperLi.get(i).getLongitude()+ "%7C";
            }
        }
        return shipperLoc;
    }

}
