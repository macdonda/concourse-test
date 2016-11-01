package com.yambay.job.service;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chrisp on 4/10/16.
 */
@Data
public class JobView {

    @ApiModelProperty(value = "The type of job", required = true)
    @NotNull
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

    private List<OperationView> operations = new ArrayList<>(0);

}
