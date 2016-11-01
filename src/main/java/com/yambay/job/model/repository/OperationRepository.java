package com.yambay.job.model.repository;

import com.yambay.job.model.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chrisp on 4/10/16.
 */
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
