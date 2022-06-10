package com.example.mythirdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn= findViewById(R.id.btn);
        lv = findViewById(R.id.lv_Brand);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url ="https://api-mobilespecs.azharimm.site/v2/brands";

                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("API RESULTAT", response);
                        List<Brand> liste_des_marques = new ArrayList<Brand>();
                        try {
                            JSONObject global = new JSONObject(response);
                            JSONArray array_brands = global.getJSONArray("data");
                                    for(int cpt=0 ; cpt<array_brands.length(); cpt++){
                                        Brand b = new Brand();
                                        b.setName(array_brands.getJSONObject(cpt).getString("brand_name"));
                                        b.setSlug(array_brands.getJSONObject(cpt).getString("brand_slug"));
                                        b.setDevice_count(array_brands.getJSONObject(cpt).getInt("device_count"));
                                        liste_des_marques.add(b);


                                     }
                                     BrandAdapter ba = new BrandAdapter(liste_des_marques, MainActivity.this);
                                    lv.setAdapter(ba);


                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Echec",Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(request);

            }
        });

    }
}