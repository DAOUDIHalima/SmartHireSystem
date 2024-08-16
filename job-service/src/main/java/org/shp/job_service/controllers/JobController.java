package org.shp.job_service.controllers;

import org.modelmapper.ModelMapper;
import org.shp.job_service.dtos.JobDto;
import org.shp.job_service.models.Job;
import org.shp.job_service.services.facade.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<JobDto> findById(@PathVariable("id") long id) {
        Job job = jobService.findById(id);
        if (job == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        JobDto jobDto = modelMapper.map(job, JobDto.class);
        return ResponseEntity.ok(jobDto);
    }

    @GetMapping("/title/{title}")
    public List<JobDto> findByTitle(@PathVariable("title") String title) {
        List<Job> jobs = jobService.findByTitle(title);
        List<JobDto> jobDtos = new ArrayList<>();
        for (Job job : jobs) {
            jobDtos.add(modelMapper.map(job, JobDto.class));
        }
        return jobDtos;
    }

    @GetMapping("/location/{location}")
    public List<JobDto> findByLocation(@PathVariable("location") String location) {
        List<Job> jobs = jobService.findByLocation(location);
        List<JobDto> jobDtos = new ArrayList<>();
        for (Job job : jobs) {
            jobDtos.add(modelMapper.map(job, JobDto.class));
        }
        return jobDtos;
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable("id") long id) {
        jobService.deleteById(id);
    }

    @PutMapping("/")
    public JobDto updateJob(@RequestBody JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        return modelMapper.map(jobService.updateJob(job), JobDto.class);
    }

    @PostMapping("/")
    public JobDto save(@RequestBody JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        job = jobService.save(job);
        if (job == null) return null;
        return modelMapper.map(job, JobDto.class);
    }
}
