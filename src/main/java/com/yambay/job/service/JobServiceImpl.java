package com.yambay.job.service;

import com.yambay.job.model.entity.Job;
import com.yambay.job.model.repository.JobRepository;
import com.yambay.job.model.entity.Operation;
import com.yambay.job.model.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chrisp on 4/10/16.
 */
@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobRepository jobRepository;
    @Autowired
    OperationRepository operationRepository;

    public void createJob(JobView jobView)
    {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new JobViewToJobPropertyMapper() );
        modelMapper.addMappings(new OperationViewToOperationPropertyMapper());

        // BeanUtils.copyProperties();

        Job job = modelMapper.map(jobView, Job.class);

        List<OperationView> operations = jobView.getOperations();
        for (OperationView operationView: operations)
        {
            Operation operation = modelMapper.map(operationView, Operation.class);
            operationRepository.save(operation);
            job.getOperations().add(operation);
        }


        jobRepository.save(job);

    }

    public JobView getJob(String jobSource, String jobCode) throws JobNotFoundException {

        Job job = jobRepository.findByJobSourceAndJobCode(jobSource,jobCode);

        if (job == null) throw new JobNotFoundException(jobSource,jobCode);

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(job, JobView.class);

    }


}
