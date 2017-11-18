package com.edinbridge.autojobs.autojobshere.Adapter;

/**
 * Created by Ayothi selvam on 17-11-2017.
 */

public class AppliedJob {

    String jobName;
    String comName;
    String date;
    String city;
    String exp;
    String minSalary;
    String maxSalary;
    String brandLogo;

    public AppliedJob(String jobName, String comName, String date, String city, String exp, String minSalary, String maxSalary, String brandLogo) {
        this.jobName = jobName;
        this.comName = comName;
        this.date = date;
        this.city = city;
        this.exp = exp;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.brandLogo = brandLogo;
    }

    public String getJobName() {
        return jobName;
    }

    public String getComName() {
        return comName;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getExp() {
        return exp;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public String getBrandLogo() {
        return brandLogo;
    }
}
