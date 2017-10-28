package com.edinbridge.autojobs.autojobshere.other;

/**
 * Created by Edinbridge on 10/24/2017.
 */

public class User {
    String name,email,phone,password;
    String otp;

    public User(String name, String email, String phone, String password,String otp){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.otp=otp;
    }

    public User(String email, String password){

        this.email=email;
        this.password=password;
        this.name="";
        this.phone= "";

    }

}
