package com.yambay.job.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by chrisp on 4/10/16.
 */
@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue
    private long operationId;

    @ManyToOne
    private Job job;

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
    protected Long operationInstructedTime;
    protected Long operationConfirmedTime;
    protected Long operationAbortedTime;
    protected String operationComponentId;
    protected String operationComponentName;
    protected String location;
    protected String circuit;
    protected String action;
    protected String text;
    protected String documentId;
    protected String documentRef;
    protected String documentDetails;
    // protected Form form;

}
