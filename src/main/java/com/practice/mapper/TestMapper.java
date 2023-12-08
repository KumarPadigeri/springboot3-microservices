package com.practice.mapper;
/*
 * @Created 1/6/2023 11:22 AM 2023
 * @Project testing-project-springboot3
 * @User Kumar Padigeri
 */


import com.practice.domain.JobsEntity;
import com.test.model.JobsAO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TestMapper {

    JobsAO jobsEntityToDTO(JobsEntity jobsEntity);

}
