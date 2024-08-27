package org.shp.job_service.services.facade;

import org.shp.job_service.dtos.JobDto;
import org.shp.job_service.models.Job;
import org.shp.job_service.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    List<JobDto> findAll();
    JobDto findById(long id);

    List<JobDto> findByTitle(String title);

    List<JobDto> findByLocation(String location);

    void deleteById(long id);

    Job updateJob(Job job);

    Job save(Job job);
}
