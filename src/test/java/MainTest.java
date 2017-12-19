import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


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

    public static void main(String[] args) throws IOException {
        MainTest request = new MainTest();
        /*
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver" +
                "+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=fr-FR&key=" + API_KEY;
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=20.9991883,105.8462537" +
                "&destinations=21.0026339,105.8563817/@20.9836422,105.862819,14z&key="+API_KEY;
                */
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?&origins=40.6655101," +
                "-73.89188969999998&destinations=40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C" +
                "-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C" +
                "-73.9976592%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C" +
                "-73.6334271%7C40.598566%2C-73.7527626%7C40.659569%2C-73.933783%7C40.729029%2C" +
                "-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key="+API_KEY;
        String response = request.run(url_request);
        System.out.println(response);

       // Double distance = SphericalUtil.computeDistanceBetween(21.0026339, 105.8563817);
    }
    //https://www.google.com/maps/dir/20.9991883,105.8462537/21.0026339,105.8563817/@20.9836422,105.862819,14z
}
