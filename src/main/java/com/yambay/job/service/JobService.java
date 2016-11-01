package com.yambay.job.service;

import org.springframework.stereotype.Service;

/**
 * Created by chrisp on 5/10/16.
 */
public interface JobService {

    void createJob(JobView jobView);

    JobView getJob(String jobSource, String jobCode) throws JobNotFoundException;


}
