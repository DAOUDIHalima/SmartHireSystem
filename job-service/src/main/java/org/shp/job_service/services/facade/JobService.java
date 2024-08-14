package org.shp.job_service.services.facade;

import org.shp.job_service.models.Job;
import org.shp.job_service.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    public Job findById(long id);

    public List<Job> findByTitle(String title);

    public List<Job> findByLocation(String location);

    public void deleteById(long id);

    public Job updateById(long id);

    public Job save(Job job);
}
