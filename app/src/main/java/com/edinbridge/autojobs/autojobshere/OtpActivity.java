package com.edinbridge.autojobs.autojobshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edinbridge.autojobs.autojobshere.other.GetUserCallback;
import com.edinbridge.autojobs.autojobshere.other.ServerRequest;
import com.edinbridge.autojobs.autojobshere.other.User;

public class OtpActivity extends AppCompatActivity {

    Button button_otp;
    EditText editText_otp;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);



        String phone_no=getIntent().getExtras().getString("phone");


        int otp=new Integer(getIntent().getExtras().getString("otp"));


        editText_otp= (EditText) findViewById(R.id.editText_otp);
        button_otp= (Button) findViewById(R.id.button_otp);


        register(phone_no,otp);




    }

    private void register(final String phone_no, final int otp) {
        button_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int otp_check=new Integer(editText_otp.getText().toString().trim());

                if ( otp == otp_check ){
                  Toast.makeText(getApplicationContext(),"User Created Sucessfully",Toast.LENGTH_SHORT).show();

                   User upDateStatus=new User(phone_no);
                    registerUser(upDateStatus);
                }
                else {
                    Toast.makeText(getApplicationContext(),"incorret correct",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void registerUser(User user){
        ServerRequest serverRequest=new ServerRequest(this);
        serverRequest.UpdateStatusInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returedUser) {

                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
