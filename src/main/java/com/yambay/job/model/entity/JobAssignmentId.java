package com.yambay.job.model.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chrisp on 4/10/16.
 */
@Embeddable
@Data
public class JobAssignmentId implements Serializable {

    private long jobId;
    private String userId;

}
