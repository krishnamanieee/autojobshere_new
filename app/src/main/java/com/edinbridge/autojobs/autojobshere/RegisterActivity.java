package com.edinbridge.autojobs.autojobshere;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.edinbridge.autojobs.autojobshere.other.GetUserCallback;
import com.edinbridge.autojobs.autojobshere.other.ServerRequest;
import com.edinbridge.autojobs.autojobshere.other.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ayothi selvam on 23-10-2017.
 */

public class  RegisterActivity extends Activity {

    CheckBox checkBox_frsher;
    TextView titletxt,upldbtntxt,agreetext,registertext;
    EditText employeredit,experienceedit,locationedit,nameedit,mobileedit,emailedit,editText_pass,edt_designation;
    Spinner spinner_dept,spinner_industry;
    Button uploadbtn,registerbtn,loginbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        checkBox_frsher = (CheckBox) findViewById(R.id.checkBox);
        titletxt = (TextView) findViewById(R.id.titletxt);
        upldbtntxt = (TextView) findViewById(R.id.upldbtntxt);
        agreetext = (TextView) findViewById(R.id.agreetext);
        registertext = (TextView) findViewById(R.id.agreetext);
        nameedit = (EditText) findViewById(R.id.nameedit);
        mobileedit = (EditText) findViewById(R.id.mobileedit);
        emailedit = (EditText) findViewById(R.id.emailedit);
        editText_pass = (EditText) findViewById(R.id.editText_pass);
        employeredit = (EditText) findViewById(R.id.employeredit);
        experienceedit = (EditText) findViewById(R.id.experienceedit);
        locationedit = (EditText) findViewById(R.id.locationedit);
        edt_designation= (EditText) findViewById(R.id.edt_designation);
        uploadbtn = (Button) findViewById(R.id.uploadbtn);
        registerbtn = (Button) findViewById(R.id.registerbtn);
        loginbtn = (Button) findViewById(R.id.registerbtn);

        spinner_dept= (Spinner) findViewById(R.id.spinner_dept);
        spinner_industry= (Spinner) findViewById(R.id.spinner_industry);

        addDeptspinner();
        addindustryspinner();


        Random r = new Random();
         int randomNumber = r.nextInt(9999);

        Toast.makeText(getApplicationContext(),""+randomNumber,Toast.LENGTH_SHORT).show();



        checkBox_frsher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    freshers();

                } else {
                    employeredit.setText("");
                    experienceedit.setText("");
                    locationedit.setText("");
                    edt_designation.setText("");
                    addDeptspinner();
                    addindustryspinner();
                }
            }
        });


        String otp = String.valueOf(randomNumber);

        register(otp);


    }

    public void freshers(){
        List<String> list =new ArrayList<String>();
        employeredit.setText("Fresher");
        experienceedit.setText("Fresher");
        locationedit.setText("Fresher");
        edt_designation.setText("Freshers");
        list.add("Fresher");
        final ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        data.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_dept.setAdapter(data);
        spinner_industry.setAdapter(data);

    }

    public void addDeptspinner(){
        List<String> list =new ArrayList<String>();
        list.add("Department");
        list.add("Finance/Account");
        list.add("General Mannagement");
        list.add("HR");
        list.add("IT");
        list.add("Pre owened vehicles");
        list.add("Sales");
        list.add("Sevice/Spare parts");
        list.add("others");

        ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        data.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_dept.setAdapter(data);


    }
    public void addindustryspinner(){
        List<String> list2 =new ArrayList<String>();
        list2.add("Segment/Industry");
        list2.add("Car");
        list2.add("Commercial Vehicle");
        list2.add("HCV");
        list2.add("LCV");
        list2.add("Two Wheeler");
        list2.add("Others");

        ArrayAdapter<String> data2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
        data2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner_industry.setAdapter(data2);


    }




    public void register(final String otp) {
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nameedit.getText().toString().trim();
                String email=emailedit.getText().toString().trim();
                String password=editText_pass.getText().toString().trim();
                String phoneno=mobileedit.getText().toString().trim();

                User registeredData=new User(name,email,phoneno,password,otp);

                registerUser(registeredData,otp);
            }
        });

    }
    private void registerUser(User user,final String otp){
        ServerRequest serverRequest=new ServerRequest(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returedUser) {

                Intent intent=new Intent(getApplicationContext(),OtpActivity.class);
                intent.putExtra("email",emailedit.getText().toString().trim());
                intent.putExtra("phone",mobileedit.getText().toString().trim());
                intent.putExtra("otp",otp.trim());
                startActivity(intent);
            }
        });
    }
}
