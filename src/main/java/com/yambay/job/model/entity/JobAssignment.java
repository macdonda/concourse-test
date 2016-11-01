package com.yambay.job.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by chrisp on 4/10/16.
 */
@Entity
@Data
public class JobAssignment {

    @Id
    private JobAssignmentId id;

    @ManyToOne
    private Job job;

    private long version;
    private int status;
    private Date createdTime;
    private Date updatedTime;

}
