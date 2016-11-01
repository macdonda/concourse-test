package com.yambay.job.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

/**
 * Created by chrisp on 4/10/16.
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"jobSource", "jobCode"}))
@Data
public class Job {

    @Id
    @GeneratedValue
    private long jobId;
    private long version;
    private String jobType;
    private String jobSource;
    private String jobCode;
    private String latitude;
    private String longitude;
    private Date scheduleDate;
    private String jobSummary;
    private String description;
    private String jobListSummary;
    private String displayOrder;
    private Integer attentionFlag;
    private String attentionComment;
    private String jobListColumn1;
    private String jobListColumn2;
    private String supervisorUser;
    // private Job.Actions actions;
    // private Job.Forms forms;
    // private Job.Equipment equipment;
    // private Job.Calls calls;
    // private Job.SensitiveCustomers sensitiveCustomers;

    @OneToMany
    private List<Operation> operations = new ArrayList<>(0);

    @OneToMany
    private List<JobAssignment> jobAssignments = new ArrayList<>(0);

}
