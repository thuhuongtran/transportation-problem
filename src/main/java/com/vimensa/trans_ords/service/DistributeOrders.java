package com.vimensa.trans_ords.service;

import com.vimensa.trans_ords.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeOrders {
    /**
     * call google map api
     * return distance between two points in the Earth
     * params: origin coordinate & destination coord
     * */
    private static final String API_KEY = "AIzaSyD56CRrDR98aaz9A1WMokw6siT0u0iiyts";
    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    /*
    * get distance between two points
    * params: lat and lot of origin and des points
    *
    * */

    public Distance getDistanceTwoPoints(String track, String oriLat, String oriLot, String desLat, String desLot) throws IOException {
        DistributeOrders request = new DistributeOrders();
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins="+oriLat+"," +
                oriLot+"&destinations="+desLat+"%2C"+desLot+"&key="+API_KEY;
        String response = request.run(url_request);
        JSONObject distJson = new JSONObject(response);
        JSONArray rowArr = (JSONArray) distJson.get("rows");
        Distance dis = new Distance();

        JSONArray ele = rowArr.getJSONObject(0).getJSONArray("elements");
        for(int i =0;i<ele.length();i++){
            JSONObject distance = ele.getJSONObject(i).getJSONObject("distance");
            String txtDis =  distance.get("text").toString();
            String valueDis = distance.get("value").toString();
            JSONObject duration = ele.getJSONObject(i).getJSONObject("duration");
            String txtTime = duration.get("text").toString();
            String valueTime = duration.get("value").toString();
            dis = new Distance(track,txtDis, valueDis, txtTime, valueTime);
        }
        return dis;

    }
    /*
    * get distance betw 1 point and mul des point
    * params: lat and lot of origin point
    *         list of lat and lot of mul des points
    * */
//
//    public List<Distance> getDistanceMulPoints(String oriLat, String oriLot,String desCoorStr) throws IOException {
//        DistributeOrders request = new DistributeOrders();
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins="+oriLat+"," +
//                oriLot+"&destinations="+desCoorStr+"&key="+API_KEY;
//        String response = request.run(url_request);
//        JSONObject distJson = new JSONObject(response);
//        JSONArray rowArr = (JSONArray) distJson.get("rows");
//        List<Distance> disLi = new ArrayList<Distance>();
//        JSONArray ele = rowArr.getJSONObject(0).getJSONArray("elements");
//        for(int i =0;i<ele.length();i++){
//            JSONObject distance = ele.getJSONObject(i).getJSONObject("distance");
//            String txtDis =  distance.get("text").toString();
//            String valueDis = distance.get("value").toString();
//            JSONObject duration = ele.getJSONObject(i).getJSONObject("duration");
//            String txtTime = duration.get("text").toString();
//            String valueTime = duration.get("value").toString();
//            Distance dis = new Distance(txtDis, valueDis, txtTime, valueTime);
//            disLi.add(dis);
//        }
//        return disLi;
//    }
    /**
    * get all of distance betwe all current working shippers and all destinations
     * ---transLi and shipperLi are updated all the time
    * */
    public List<Distance> getAllShipperLocToOrdDesDis(List<Shipper> shipperLi, List<TransOrd> transLi) throws IOException {
        TransOrdManager transMang = new TransOrdManager();
        ShipperManager shipperMang = new ShipperManager();
        String desCoorStr = transMang.getOriCoordLi(transLi);
        String shipperLoc = shipperMang.getShipperLocationLi(shipperLi);

        DistributeOrders request = new DistributeOrders();
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins="+shipperLoc+
                "&destinations="+desCoorStr+"&key="+API_KEY;
//        String url_request = "https://vimensa.maps.com/maps/api/distancematrix/json?&origins="+shipperLoc+
//                "&destinations="+desCoorStr;
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=" +
//                "21.0000281%2C105.9072344%7C20.9980975%2C105.8752846%7C21.0000281%2C105.9072344" +
//                "&destinations="+desCoorStr;
//        System.out.println(url_request);
        String response = request.run(url_request);
        System.out.println(response);
        JSONObject distJson = new JSONObject(response);
        JSONArray rowArr = (JSONArray) distJson.get("rows");
        List<Distance> disLi = new ArrayList<Distance>();
        JSONArray ele = rowArr.getJSONObject(0).getJSONArray("elements");
        for(int i =0;i<ele.length();i++){
            JSONObject distance = ele.getJSONObject(i).getJSONObject("distance");
            String txtDis =  distance.get("text").toString();
            String valueDis = distance.get("value").toString();
            JSONObject duration = ele.getJSONObject(i).getJSONObject("duration");
            String txtTime = duration.get("text").toString();
            String valueTime = duration.get("value").toString();
            Distance dis = new Distance(txtDis, valueDis, txtTime, valueTime);
            disLi.add(dis);
        }
        return disLi;
    }
    /**
     * distribute orders to shippers
     * param: list of shippers
     *        list of drivers
     * */
    public void distributeOrders(List<Shipper> shipperLi, List<TransOrd> transLi){

    }

}