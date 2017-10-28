package com.edinbridge.autojobs.autojobshere;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtpActivity extends AppCompatActivity {

    Button button_otp;
    EditText editText_otp;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

         String otp =getIntent().getExtras().getString("otp");

        editText_otp= (EditText) findViewById(R.id.editText_otp);
        button_otp= (Button) findViewById(R.id.button_otp);


        register(otp);




    }

    private void register(final String otp) {
        button_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp_check = editText_otp.getText().toString();
                Toast.makeText(getApplicationContext(),"click  OTP",Toast.LENGTH_SHORT);

                if (otp == otp_check){

                    Toast.makeText(getApplicationContext(),"correct OTP",Toast.LENGTH_SHORT);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT);

                }

            }
        });







    }
}
