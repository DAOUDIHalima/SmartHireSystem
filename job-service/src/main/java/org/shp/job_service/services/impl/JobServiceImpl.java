package org.shp.job_service.services.impl;


import org.shp.job_service.models.Job;
import org.shp.job_service.services.facade.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Override
    public Job findById(long id) {
        return null;
    }

    @Override
    public List<Job> findByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Job> findByLocation(String location) {
        return List.of();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Job updateById(long id) {
        return null;
    }

    @Override
    public Job save(Job job) {
        return null;
    }
}
