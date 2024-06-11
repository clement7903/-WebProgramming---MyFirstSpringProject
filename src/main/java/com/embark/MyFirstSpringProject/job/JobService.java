package com.embark.MyFirstSpringProject.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getById(Long id);
    Boolean deleteJob(Long id);
    boolean updateJob(Long id, Job updatedJob);
}
