package com.vimensa.trans_ords.model;

import java.util.List;

public class TransOrdManager {
    /**
     * get list of origin points in all orders
     * param: list of all orders
     * use: to call google map api
     */
    public String getOriCoordLi(List<TransOrd> transOrdLi) {
        String oriCoorLi = "";
        for (int i = 0; i < transOrdLi.size(); i++) {
            if (i == transOrdLi.size() - 1) {
                oriCoorLi = oriCoorLi + transOrdLi.get(i).getOriginLatitude() + "%2C" + transOrdLi.get(i).getOriginLongitude();
            }
            else{
                oriCoorLi = oriCoorLi + transOrdLi.get(i).getOriginLatitude() + "%2C" + transOrdLi.get(i).getOriginLongitude() + "%7C";
            }
        }
        return oriCoorLi;
    }
}
