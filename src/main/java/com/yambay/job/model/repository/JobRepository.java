package com.yambay.job.model.repository;

import com.yambay.job.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chrisp on 4/10/16.
 */
public interface JobRepository extends JpaRepository<Job,Long> {

    Job findByJobSourceAndJobCode(String jobSource, String jobCode);

}
