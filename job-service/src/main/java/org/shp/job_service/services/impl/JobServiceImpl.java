package org.shp.job_service.services.impl;


import org.modelmapper.ModelMapper;
import org.shp.job_service.dtos.JobDto;
import org.shp.job_service.models.Job;
import org.shp.job_service.repositories.JobRepository;
import org.shp.job_service.services.facade.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private  KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "new_jobs";
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<JobDto> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(job -> modelMapper.map(job, JobDto.class)).collect(Collectors.toList());
    }

    @Override
    public JobDto findById(long id) {
        Optional job = jobRepository.findById(id);
        return modelMapper.map(job.get(), JobDto.class);
    }

    @Override
    public List<JobDto> findByTitle(String title) {
        List<Job> jobs = jobRepository.findJobsByTitleIs(title);
        return jobs.stream().map(job -> modelMapper.map(job, JobDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<JobDto> findByLocation(String location) {
        List<Job> jobs = jobRepository.findJobsByLocation(location);
        return jobs.stream().map(job -> modelMapper.map(job, JobDto.class)).collect(Collectors.toList());
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
        kafkaTemplate.send(TOPIC, "New job posted: " + job.getTitle());
        return jobRepository.save(job);
    }
}
