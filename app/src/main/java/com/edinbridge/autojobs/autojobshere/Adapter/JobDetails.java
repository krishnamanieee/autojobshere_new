package com.edinbridge.autojobs.autojobshere.Adapter;

/**
 * Created by krish on 11/18/2017.
 */

public class JobDetails {

    String jobName,companyName,cityName,minExp,maxExp,minSalary,maxSalary,date,logo;

    String ivDate,ivTime,jobCode,location;

    public JobDetails(String jobName, String companyName, String cityName, String logo, String ivDate, String ivTime, String jobCode, String location) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.cityName = cityName;
        this.logo = logo;
        this.ivDate = ivDate;
        this.ivTime = ivTime;
        this.jobCode = jobCode;
        this.location = location;
    }

    public JobDetails(String jobName, String companyName, String cityName, String minExp, String maxExp, String minSalary, String maxSalary, String date, String logo) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.cityName = cityName;
        this.minExp = minExp;
        this.maxExp = maxExp;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.date = date;
        this.logo = logo;
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

    public String getMinExp() {
        return minExp;
    }

    public String getMaxExp() {
        return maxExp;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public String getDate() {
        return date;
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
