import com.vimensa.trans_ords.data_config.OrdersConfig;
import com.vimensa.trans_ords.model.Distance;
import com.vimensa.trans_ords.model.TransOrdManager;
import com.vimensa.trans_ords.service.DistributeOrders;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
* Note: can khoanh vung shipper and transOrd theo province. Ex:  shippers in HN, HCM,...
*                                                                orders in HN, HCM,...
* */
public class MainTest {
    private static final String API_KEY = "AIzaSyD56CRrDR98aaz9A1WMokw6siT0u0iiyts";

    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
//
//    public static void main(String[] args) throws IOException {
//
//        MainTest request = new MainTest();
//        /*
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver" +
//                "+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=fr-FR&key=" + API_KEY;
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=20.9991883,105.8462537" +
//                "&destinations=21.0026339,105.8563817/@20.9836422,105.862819,14z&key="+API_KEY;
//                */
//        /*
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=40.6655101," +
//                "-73.89188969999998&destinations=40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C" +
//                "-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C" +
//                "-73.9976592%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C" +
//                "-73.6334271%7C40.598566%2C-73.7527626%7C40.659569%2C-73.933783%7C40.729029%2C" +
//                "-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key="+API_KEY;
//                */
//
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=21.0291064," +
//                "105.8342839&destinations=21.0277887%2C105.8561511";
//        String response = request.run(url_request);
//        System.out.println(response);
//        /*
//        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=21.0291064," +
//                "105.8342839&destinations=20.9857814%2C105.8327653%7C21.0271357%2C105.8393332%7C20.992693%2C105.8496953%" +
//                "7C20.995358%2C105.7845946%7C21.0553007%2C105.8773542%7C21.0283229%2C105.8427901%7C20.9639914%2C105.7222" +
//                "787%7C20.9496558%2C105.8413131%7C20.9239655%2C105.8339645%7C21.0465492%2C105.7823693%7C21.0772623%2C105" +
//                ".7718988%7C21.0330265%2C105.8329392%7C21.0313596%2C105.8548224%7C21.0414744%2C105.8450603%7C20.979500%2" +
//                "C105.850780%7C21.1107264%2C105.781135%7C21.0684833%2C105.7857594%7C21.0399138%2C105.8005432%7C21.019344" +
//                "2%2C105.8217342%7C20.8799738%2C105.8794402%7C20.9848383%2C105.8265851%7C21.0291064%2C105.8342839%7C21.02" +
//                "40197%2C105.8787244%7C20.9963952%2C105.8220664%7C20.9617695%2C105.7093862%7C21.0253647%2C105.8332973";
//        String response = request.run(url_request);
//        System.out.println(response);
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
//        for(Distance dis: disLi){
//            System.out.println(dis.getTxtDis()+" "+dis.getValueDis()+" "+dis.getTxtTime()+" "+dis.getValueTime());
//        }
//        */
//
//       // Double distance = SphericalUtil.computeDistanceBetween(21.0026339, 105.8563817);
//    }

    //https://www.google.com/maps/dir/20.9991883,105.8462537/21.0026339,105.8563817/@20.9836422,105.862819,14z


    public static void main(String[] args) throws IOException {

        DistributeOrders distributeOrders = new DistributeOrders();
//        distributeOrders.getDistanceTwoPoints("20.9963952","105.8220664","20.9876666","105.7729941");
//
        OrdersConfig.getOrders();
        TransOrdManager transOrdManager = new TransOrdManager();

        System.out.println(transOrdManager.getOriCoordLi(OrdersConfig.orders));


        List<Distance> disLi = distributeOrders.getDistanceMulPoints("21.0000281","105.9072344",
                transOrdManager.getOriCoordLi(OrdersConfig.orders));

        for(Distance dis: disLi){
            System.out.println(dis.getTxtDis()+" "+dis.getValueDis()+" "+dis.getTxtTime()+" "+dis.getValueTime());
        }
    }
}
