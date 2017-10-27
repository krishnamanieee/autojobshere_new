package com.edinbridge.autojobs.autojobshere;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edinbridge.autojobs.autojobshere.other.GetUserCallBack;
import com.edinbridge.autojobs.autojobshere.other.ServerRequest;
import com.edinbridge.autojobs.autojobshere.other.User;
import com.edinbridge.autojobs.autojobshere.other.UserLocalStore;


/**
 * Created by Ayothi selvam on 19-10-2017.
 */

public class LoginActivity extends Activity {

    EditText editText_username,editText_password;
    Button button_login,button_reg;
    UserLocalStore userLocalstore;
    TextView textView_forgot;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_username= (EditText) findViewById(R.id.edt_login_email);
        editText_password= (EditText) findViewById(R.id.edt_login_password);
        textView_forgot= (TextView) findViewById(R.id.txt_forgot);
        button_login= (Button) findViewById(R.id.button_login);
        button_reg= (Button) findViewById(R.id.btn_register);

        userLocalstore=new UserLocalStore(this);

        logIn();
        register();
        forgotPassword();



    }

    private void logIn() {

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=editText_username.getText().toString();
                String pass=editText_password.getText().toString();
                User user=new User(username,pass);
                authenticate(user);
            }
        });
    }

    private void authenticate(User user){
        ServerRequest serverRequest=new ServerRequest(this);
        serverRequest.fetchUserDataInBackground(user, new GetUserCallBack() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null){
                    showErrorMessage();
                }else {
                    logUserIn(returnedUser );
                }
            }
        });
    }

    private void showErrorMessage(){

        android.support.v7.app.AlertDialog.Builder builder=new android.support.v7.app.AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Incorrect user details :(");
        builder.setPositiveButton("ok",null);
        builder.show();

    }

    private void logUserIn(User returnedUser ){

        userLocalstore.storeUserData(returnedUser);
        userLocalstore.setUserLoggedIn(true);

        startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }


    public void register(){

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    public void forgotPassword(){

        textView_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FotgotPwd.class);
                startActivity(intent);
            }
        });

    }





}
