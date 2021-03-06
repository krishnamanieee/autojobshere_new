package com.edinbridge.autojobs.autojobshere.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.edinbridge.autojobs.autojobshere.R;
import com.edinbridge.autojobs.autojobshere.SearchedActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchJobFragmet.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchJobFragmet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchJobFragmet extends Fragment {
    Spinner spinner_segment,spinner_city,spinner_department;
    Button button_search;

    List<String> arrayList;
    List<String> arrayListDep;

    String segment,city,department;



    private static final String URL_DATA="http://autojobshere.com/app/fetch_city.php";
    private static final String URL_DATA_DEPARTMENT="http://autojobshere.com/app/fetch_department.php";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SearchJobFragmet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchJobFragmet.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchJobFragmet newInstance(String param1, String param2) {
        SearchJobFragmet fragment = new SearchJobFragmet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_seach, container, false);
        spinner_segment=(Spinner) v.findViewById(R.id.spinner_segment);
        spinner_city=(Spinner) v.findViewById(R.id.spinner_city);
        spinner_department=(Spinner) v.findViewById(R.id.spinner_department);

        button_search=(Button) v.findViewById(R.id.button_homeSearch);







        arrayList= new ArrayList<>();
        arrayListDep= new ArrayList<>();



        addLoanOption();

        spinner_segment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                getCity();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getDepartment();
            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        searchJobs();


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void addLoanOption() {

        List<String> list =new ArrayList<String>();
        list.add("Select Segment");
        list.add("Car");
        list.add("Commercial Vehicle");
        list.add("HCV");
        list.add("LCV");
        list.add("Two Wheeler");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.spiner_item,list);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spiner_item);
        spinner_segment.setAdapter(spinnerArrayAdapter);

        List<String> list1 =new ArrayList<String>();
        list1.add("Select City");
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(getContext(),R.layout.spiner_item,list1);
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spiner_item);
        spinner_city.setAdapter(spinnerArrayAdapter1);

        List<String> list2 =new ArrayList<String>();
        list2.add("Select Department");
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(getContext(),R.layout.spiner_item,list2);
        spinnerArrayAdapter1.setDropDownViewResource(R.layout.spiner_item);
        spinner_department.setAdapter(spinnerArrayAdapter2);


    }

    private void searchJobs() {

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                department=spinner_department.getSelectedItem().toString();
                Intent intent=new Intent(getContext(),SearchedActivity.class);
                intent.putExtra("segment",segment);
                intent.putExtra("city",city);
                intent.putExtra("department",department);
                startActivity(intent);
            }
        });


    }
    private void getDepartment() {
        final ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("loading Data....");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST,
                URL_DATA_DEPARTMENT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        arrayListDep.clear();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("department");
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject  object=jsonArray.getJSONObject(i);
                                arrayListDep.add(object.getString("department"));
                            }

                            String s1=arrayListDep.toString();
                         //   Toast.makeText(getContext(),s1,Toast.LENGTH_SHORT).show();
                            Collections.sort(arrayListDep);
                            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.spiner_item, arrayListDep);
                            spinnerArrayAdapter.setDropDownViewResource(R.layout.spiner_item);
                            spinner_department.setAdapter(spinnerArrayAdapter);



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

                city=spinner_city.getSelectedItem().toString();

                // Adding All values to Params.
                params.put("city", city);
                return params;
            }



        };

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void getCity() {
        final ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("loading Data....");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        arrayList.clear();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("city");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject  object=jsonArray.getJSONObject(i);
                                arrayList.add(object.getString("city"));
                            }
                            String s=arrayList.toString();
                           // Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
                            Collections.sort(arrayList);
                            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.spiner_item, arrayList);
                            spinnerArrayAdapter.setDropDownViewResource(R.layout.spiner_item);
                            spinner_city.setAdapter(spinnerArrayAdapter);
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

                segment=spinner_segment.getSelectedItem().toString();

                // Adding All values to Params.
                params.put("segment", segment);
                return params;
            }



        };

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}
