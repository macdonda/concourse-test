package com.yambay.job.service;

import com.yambay.job.model.entity.Operation;
import org.modelmapper.PropertyMap;

/**
 * Created by chrisp on 4/10/16.
 */
public class OperationViewToOperationPropertyMapper extends PropertyMap<OperationView, Operation> {

protected void configure() {

        skip().setOperationId(0);

        }

}
