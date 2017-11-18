package com.edinbridge.autojobs.autojobshere.Adapter;

/**
 * Created by krish on 11/18/2017.
 */

public class JobDetails {

    String jobName,companyName,cityName,experience,salary,date;

    public JobDetails(String jobName, String companyName, String cityName, String experience, String salary, String date) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.cityName = cityName;
        this.experience = experience;
        this.salary = salary;
        this.date = date;
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

    public String getExperience() {
        return experience;
    }

    public String getSalary() {
        return salary;
    }

    public String getDate() {
        return date;
    }
}
