package com.edinbridge.autojobs.autojobshere.Adapter;

/**
 * Created by Ayothi selvam on 11/28/2017.
 */

public class HotJob {

    String companyName,city,logo;

    public HotJob(String companyName, String city, String logo) {
        this.companyName = companyName;
        this.city = city;
        this.logo = logo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCity() {
        return city;
    }

    public String getLogo() {
        return logo;
    }
}
