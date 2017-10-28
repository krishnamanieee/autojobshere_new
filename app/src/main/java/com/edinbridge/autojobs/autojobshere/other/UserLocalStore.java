package com.edinbridge.autojobs.autojobshere.other;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Edinbridge on 10/25/2017.
 */

public class UserLocalStore {

    public  static final String SP_NAME="userDetails";
    SharedPreferences userlocalDatabase;

    public UserLocalStore(Context context){
        userlocalDatabase=context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor=userlocalDatabase.edit();
        spEditor.putString("email",user.email);
        spEditor.putString("password",user.password);
        spEditor.putString("name",user.name);
        spEditor.putString("phone",user.phone);
        spEditor.putString("otp",user.otp);
        spEditor.commit();
    }
    public User getLoggedInUser(){
        String name=userlocalDatabase.getString("email","");
        String phoneno=userlocalDatabase.getString("password","");
        String username=userlocalDatabase.getString("name","");
        String pass=userlocalDatabase.getString("phone","");
        String otp=userlocalDatabase.getString("otp","");

        User storedUser=new User(name,username,phoneno,pass,otp);
        return  storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor=userlocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if(userlocalDatabase.getBoolean("loggedIn",false)){
            return  true;
        }
        else {
            return false;
        }
    }

    public  void clearUserData(){
        SharedPreferences.Editor spEditor=userlocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

}
