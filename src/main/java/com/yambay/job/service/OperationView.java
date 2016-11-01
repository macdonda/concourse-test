package com.yambay.job.service;

import lombok.Data;

import java.util.Date;

/**
 * Created by chrisp on 4/10/16.
 */
@Data
public class OperationView {

    protected String externalId;
    protected String operationDisplayOrder;
    protected String operationType;
    protected String operationStatus;
    protected String displayedState;
    protected String operationDisplayText;
    protected String operationSummary;
    protected String operationDisplayId;
    protected String operationStatusFlowId;
    protected String userId;
    protected String operationNotes;
    protected Date operationInstructedTime;
    protected Date operationConfirmedTime;
    protected Date operationAbortedTime;
    protected String operationComponentId;
    protected String operationComponentName;
    protected String location;
    protected String circuit;
    protected String action;
    protected String text;
    protected String documentId;
    protected String documentRef;
    protected String documentDetails;
}
