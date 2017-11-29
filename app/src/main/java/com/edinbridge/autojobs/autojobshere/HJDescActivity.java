package com.edinbridge.autojobs.autojobshere;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.edinbridge.autojobs.autojobshere.Adapter.AdapterSearchedJob;
import com.edinbridge.autojobs.autojobshere.Adapter.JobDetails;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HJDescActivity extends AppCompatActivity {

    TextView textView_cmyName,textView_city;

    String cmyName,city;
    private static String s;
    JobDetails jobDetails;
    MapView mapView;
    GoogleMap map;

    private static final String URL_DATA = "http://autojobshere.com/app/hotjobs.php";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<JobDetails> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_hjdesc);

        textView_cmyName= (TextView) findViewById(R.id.hjDesc_txt_cmyNmae);
        textView_city= (TextView) findViewById(R.id.hjDesc_txt_city);
        mapView=(MapView)findViewById(R.id.mapView_hj);

        mapView.onCreate(savedInstanceState);
        map = mapView.getMapAsync();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerView_hotdes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        list=new ArrayList<>();



        if (getIntent().getExtras().getString("cmyNmae").length() > 0) {

            cmyName=getIntent().getExtras().getString("cmyNmae");

            city=getIntent().getExtras().getString("city");
            textView_cmyName.setText(cmyName);
            textView_city.setText(city);


        }

        s=textView_cmyName.getText().toString();
       // Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        loadJob();
    }

    private void loadJob() {



            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("loading data");
            progressDialog.show();


            StringRequest stringRequest  = new StringRequest(Request.Method.POST,
                    URL_DATA,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {

                            progressDialog.dismiss();

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray =jsonObject.getJSONArray("hotjobs");
                                for (int i=0;i<jsonArray.length();i++){
                                    JSONObject  jsonObject1 = jsonArray.getJSONObject(i);

                                     jobDetails=new JobDetails(
                                            jsonObject1.getString("role"),
                                            jsonObject1.getString("company"),
                                            jsonObject1.getString("city"),
                                            jsonObject1.getString("experience"),
                                            jsonObject1.getString("maxexp"),
                                            jsonObject1.getString("salary"),
                                            jsonObject1.getString("maxsal"),
                                            jsonObject1.getString("id"),
                                            jsonObject1.getString("logo")
                                    );
                                    list.add(jobDetails);
                                }

                                adapter=new AdapterSearchedJob(list,getApplicationContext());
                                recyclerView.setAdapter(adapter);




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                @Override
                protected Map<String, String> getParams() {
                    // Creating Map String Params.
                    Map<String, String> params = new HashMap<String, String>();
                    // Adding All values to Params.

                    params.put("companyy", s);

                    return params;
                }

            };


            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    }

