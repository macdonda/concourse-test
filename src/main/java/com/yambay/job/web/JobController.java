package com.yambay.job.web;

import com.yambay.job.service.JobNotFoundException;
import com.yambay.job.service.JobService;
import com.yambay.job.service.JobView;
import com.yambay.rest.util.RestErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisp on 4/10/16.
 */
@RestController
public class JobController {

    public static String RESOURCE_JOB = "JOB";

    @Autowired
    JobService service;

    @PostMapping(value = "/job/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Returns a job for a given jobSource and jobCode")
    @ApiResponses(value = {@ApiResponse(code = 404, message ="Not Found", response = RestErrorResponse.class)})
    public void createJob(@Valid @RequestBody JobView jobView)
    {
        service.createJob(jobView);
    }

    @GetMapping(value = "/job/{jobSource}/{jobCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JobView getJob(@PathVariable String jobSource, @PathVariable String jobCode) throws JobNotFoundException
    {

        JobView job = service.getJob(jobSource, jobCode);

        JobView target = new JobView();
        BeanUtils.copyProperties(job, target);

        return target;
    }

    @ExceptionHandler(JobNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestErrorResponse jobNotFoundActiveException(HttpServletRequest req, JobNotFoundException ex) {

        String errorMessage = ex.getMessage();

        String errorURL = req.getRequestURL().toString();
        RestErrorResponse errorResponse = new RestErrorResponse(errorURL, errorMessage);
        List<String> parameters = new ArrayList<>(1);
        parameters.add(RESOURCE_JOB);
        parameters.add(ex.getJobSource());
        parameters.add(ex.getJobCode());
        errorResponse.setParameters(parameters);
        return errorResponse;
    }

}
