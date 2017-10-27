package com.edinbridge.autojobs.autojobshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {


   Button btn_reg,btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

     //   TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "assets/fonts/Roboto-Regular.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf

        btn_reg= (Button) findViewById(R.id.btn_register);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent reg =new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(reg);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent reg =new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(reg);
            }
        });


    }
}
