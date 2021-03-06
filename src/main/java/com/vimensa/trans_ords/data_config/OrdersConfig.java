package com.vimensa.trans_ords.data_config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vimensa.trans_ords.model.TransOrd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersConfig {
    public static final String TRANS_ORDS_FILE = "data/trans_orders.json";
    public static List<TransOrd> orders = new ArrayList<TransOrd>();

    public static JsonObject config;
    public static void getOrders(){
        initJson();
        JsonArray arr = config.getAsJsonArray("ords");
        for(int i=0;i<arr.size();i++){
            JsonObject obj = arr.get(i).getAsJsonObject();
            String id = obj.get("num").getAsString();
            String oriName = obj.get("oriName").getAsString();
            String oriLat = obj.get("oriLat").getAsString();
            String oriLot = obj.get("oriLot").getAsString();
            String desName = obj.get("desName").getAsString();
            String desLat = obj.get("desLat").getAsString();
            String desLot = obj.get("desLot").getAsString();
            TransOrd transOrd = new TransOrd(id, oriName, oriLot, oriLat, desName, desLot, desLat);
            orders.add(transOrd);
         }

    }
    private static void initJson(){
        File file = new File(TRANS_ORDS_FILE);
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;
        try {
            Reader r = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(r);
            String text = null;
            while((text = reader.readLine())!=null){
                contents.append(text).append(System.getProperty("line.separator"));
            }
            config = toJsonObject(contents.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * Gson is to convert a java obj to json obj in opposition
     * */
    private static Gson gson = new Gson();
    /*
     * turn json string to jsonObject
     * */
    public static JsonObject toJsonObject(String json){
        try {
            return gson.fromJson(json, JsonObject.class);
        }catch (Exception e){
            return null;
        }
    }
}
