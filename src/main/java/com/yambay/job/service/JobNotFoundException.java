package com.yambay.job.service;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by chrisp on 5/10/16.
 */
public class JobNotFoundException extends Exception {

    @Getter
    private String jobSource;
    @Getter
    private String jobCode;

    public JobNotFoundException(String jobSource, String jobCode)
    {
        super("Job with jobSource:" + jobSource + " and jobCode:" + jobCode + " does not exist");
        this.jobSource = jobSource;
        this.jobCode = jobCode;
    }

}
