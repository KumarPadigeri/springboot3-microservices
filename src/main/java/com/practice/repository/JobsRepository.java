package com.practice.repository;

import com.practice.domain.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JobsRepository extends JpaRepository<JobsEntity, Integer> {


    List<JobsEntity> findByAppliedon(Date todaysDate);

}
