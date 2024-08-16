package org.shp.job_service.services.impl;


import org.shp.job_service.models.Job;
import org.shp.job_service.repositories.JobRepository;
import org.shp.job_service.services.facade.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job findById(long id) {
        return jobRepository.findById(id);
    }

    @Override
    public List<Job> findByTitle(String title) {
        return jobRepository.findByTitle(title);
    }

    @Override
    public List<Job> findByLocation(String location) {
        return jobRepository.findByLocation(location);
    }

    @Override
    public void deleteById(long id) {
        jobRepository.deleteById(id);

    }

    @Override
    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }
}
