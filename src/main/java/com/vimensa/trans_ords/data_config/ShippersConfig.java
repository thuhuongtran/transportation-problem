package com.vimensa.trans_ords.data_config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vimensa.trans_ords.model.Shipper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShippersConfig {
    public static final String TRANS_ORDS_FILE = "data/drivers.json";
    public static List<Shipper> orders = new ArrayList<Shipper>();

    public static JsonObject config;
    public static void getOrders(){
        initJson();
        JsonArray arr = config.getAsJsonArray("shippers");
        for(int i=0;i<arr.size();i++){
            JsonObject obj = arr.get(i).getAsJsonObject();
            String id = obj.get("num").getAsString();
            String name = obj.get("name").getAsString();
            String lat = obj.get("latitude").getAsString();
            String lot = obj.get("longitude").getAsString();

            Shipper shipper = new Shipper(id, name, lot, lat);
            orders.add(shipper);
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
