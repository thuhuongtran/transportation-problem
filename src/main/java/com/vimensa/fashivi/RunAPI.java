package com.vimensa.fashivi;

import com.vimensa.fashivi.model.Order;
import com.vimensa.fashivi.service.OrderProcess;

import java.io.IOException;

public class RunAPI {
    public static void main(String[] args) {
        Order order = new Order("O23", 21.0240197, 105.8787244, 21.0826459, 105.7722861);
        try {
            String driverID = OrderProcess.getDriver(order);
            System.out.println(driverID);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
