package foody.com;

import android.app.Activity;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MySQLConnect {
    private final Activity main;
    private List<String> list;
    private String URL = "http://157.230.42.137/", GET_URL="android/get_quan.php";

    public MySQLConnect(){
        main = null;

    }
    public MySQLConnect(Activity mainA){
        main = mainA;
        list = new ArrayList<String>();
    }
    public List<String> getData(){
        String url = URL + GET_URL;
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJson(response);
                Toast.makeText(main, list.get(0), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(main, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(main.getApplicationContext());
        requestQueue.add(stringRequest);

        return list;
    }
    private void showJson(String response){
        String ten_quan = "";

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0; i < result.length(); i++){
                JSONObject collectData = result.getJSONObject(i);
                ten_quan = collectData.getString("ten_quan");
                list.add(ten_quan);
            }
        }catch (JSONException ex){
            ex.printStackTrace();
        }
    }
}
