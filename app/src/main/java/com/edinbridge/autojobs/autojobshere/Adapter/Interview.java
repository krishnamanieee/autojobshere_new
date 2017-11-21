package com.edinbridge.autojobs.autojobshere.Adapter;

/**
 * Created by krish on 11/18/2017.
 */

public class Interview {

    String jobName,companyName,cityName,logo, ivDate,ivTime,jobCode,location;


    public Interview(String jobName, String companyName, String cityName, String logo, String ivDate, String ivTime, String jobCode, String location) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.cityName = cityName;
        this.logo = logo;
        this.ivDate = ivDate;
        this.ivTime = ivTime;
        this.jobCode = jobCode;
        this.location = location;
    }

    public String getJobName() {
        return jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getLogo() {
        return logo;
    }

    public String getIvDate() {
        return ivDate;
    }

    public String getIvTime() {
        return ivTime;
    }

    public String getJobCode() {
        return jobCode;
    }

    public String getLocation() {
        return location;
    }
}
