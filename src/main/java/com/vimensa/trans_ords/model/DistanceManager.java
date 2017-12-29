package com.vimensa.trans_ords.model;

import com.vimensa.trans_ords.service.DistributeOrders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistanceManager {
    public static List<Distance> disLi;

    public List<Distance> getDisLi() {
        return disLi;
    }

    public void setDisLi(List<Distance> disLi) {
        this.disLi = disLi;
    }

    /**
     * get distance between all shippers and orders
     * return: list of Distance
     * param: shipper, list of transOrd
     * note: implement merge sort later
     */
//    public static List<Distance> getDisShipperAllOrd(Shipper shipper, List<TransOrd> transLi) throws IOException {
//        DistributeOrders distributeOrders = new DistributeOrders();
//        List<Distance> disLi = new ArrayList<>();
//        for (TransOrd trans : transLi) {
//            Distance dis = new Distance();
//            dis.setTrack(shipper.getId() + "_" + trans.getId());
//            dis = distributeOrders.getDistanceTwoPoints(dis.getTrack(), shipper.getLatitude(), shipper.getLongitude(),
//                    trans.getDesLatitude(), trans.getDesLongitude());
//            disLi.add(dis);
//        }
//        return disLi;
//    }

    /**
     * get all distances between all shippers and all orders - using harvesine
     * implement alg later
     * */
    public static List<Distance> getAllDistanceShipperOrder(List<Shipper> shipperLi,List<TransOrd> transLi){
        List<Distance> disLi = new ArrayList<>();
        for(Shipper shipper: shipperLi){
            for(TransOrd ord: transLi){
                Distance dis = new Distance();
                dis.setTrack(shipper.getId()+"_"+ord.getId());
                dis.setValueDis(DistanceCalculator.distance(
                        shipper.getLatitude(),shipper.getLongitude(),
                        ord.getOriginLatitude(),ord.getOriginLongitude()));

                disLi.add(dis);
            }
        }
        return disLi;
    }
    /**
     * get all distance of all orders
     * implement alg later* */
    public static List<Distance> getAllDistanceOrder(List<TransOrd> transLi){
        List<Distance> disLi = new ArrayList<>();
        for(int i =0;i<transLi.size();i++){
            Distance dis = new Distance();
            dis.setTrack(transLi.get(i).getId()+"_"+transLi.get(i).getId());
            dis.setValueDis(DistanceCalculator.distance(transLi.get(i).getOriginLatitude(),
                    transLi.get(i).getOriginLongitude(),transLi.get(i).getDesLatitude(),
                    transLi.get(i).getDesLongitude()));
            disLi.add(dis);
        }
        return disLi;
    }


}
