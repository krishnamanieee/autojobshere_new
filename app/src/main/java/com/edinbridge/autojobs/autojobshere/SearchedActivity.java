package com.edinbridge.autojobs.autojobshere;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.edinbridge.autojobs.autojobshere.Adapter.AdapterSavedJob;
import com.edinbridge.autojobs.autojobshere.Adapter.AdapterSearchedJob;
import com.edinbridge.autojobs.autojobshere.Adapter.JobDetails;
import com.edinbridge.autojobs.autojobshere.other.UserLocalStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchedActivity extends AppCompatActivity {

    private static final String URL_DATA = "http://autojobshere.com/app/FetchsearchedJob.php";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<JobDetails> list;

    String segment,city,department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_searched);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView_searchedJob);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        list = new ArrayList<>();
        loadSearchedjobs();

    }

    private void loadSearchedjobs() {

        if(getIntent().getExtras().getString("segment").length()>0) {
            segment = getIntent().getExtras().getString("segment").toString();
            city = getIntent().getExtras().getString("city").toString();
            department = getIntent().getExtras().getString("department").toString();


          //  Toast.makeText(SearchedActivity.this,segment+"\n"+city+"\n"+department,Toast.LENGTH_SHORT).show();

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
                            JSONArray jsonArray =jsonObject.getJSONArray("searchedjobs");


                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject  jsonObject1 = jsonArray.getJSONObject(i);

                                JobDetails jobDetails=new JobDetails(
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
                params.put("segment", segment);
                params.put("city", city);
                params.put("department", department);
                return params;
            }

        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
