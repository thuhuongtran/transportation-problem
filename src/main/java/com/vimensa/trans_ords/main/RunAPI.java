package com.vimensa.trans_ords.main;

import com.vimensa.trans_ords.data_config.OrdersConfig;
import com.vimensa.trans_ords.data_config.ShippersConfig;
import com.vimensa.trans_ords.model.Distance;
import com.vimensa.trans_ords.model.DistanceManager;
import com.vimensa.trans_ords.model.Shipper;

import java.io.IOException;

public class RunAPI {
    public static void main(String[] args) throws InterruptedException, IOException {
        OrdersConfig.getOrders();
        ShippersConfig.getShippers();

//        for (Shipper shipper : ShippersConfig.shippers) {
////            DistanceManager.disLi.addAll();
//            DistanceManager.getDisShipperAllOrd(shipper, OrdersConfig.orders);
////            Thread.sleep(200);
//        }

        //print
        for (Distance dis : DistanceManager.disLi) {
            System.out.println(dis.getTrack() + " " + dis.getValueDis() + " " + dis.getValueTime());
        }
    }

}
