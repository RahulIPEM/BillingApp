package com.ibridotechnologies.billingapp.model;

public class JobParams {

    private static int jobType_id;
    private static String jobType;

    public static int getJobType_id() {
        return jobType_id;
    }

    public static void setJobType_id(int jobType_id) {
        JobParams.jobType_id = jobType_id;
    }

    public static String getJobType() {
        return jobType;
    }

    public static void setJobType(String jobType) {
        JobParams.jobType = jobType;
    }
}
