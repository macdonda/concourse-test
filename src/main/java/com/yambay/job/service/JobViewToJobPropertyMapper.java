package com.yambay.job.service;

import com.yambay.job.model.entity.Job;
import org.modelmapper.PropertyMap;

/**
 * Created by chrisp on 4/10/16.
 */
public class JobViewToJobPropertyMapper extends PropertyMap<JobView, Job> {

protected void configure() {

        skip().setOperations(null);

}

}
