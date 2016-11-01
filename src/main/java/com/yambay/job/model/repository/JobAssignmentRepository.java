package com.yambay.job.model.repository;

import com.yambay.job.model.entity.JobAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chrisp on 4/10/16.
 */
public interface JobAssignmentRepository extends JpaRepository<JobAssignment,Long> {


}
