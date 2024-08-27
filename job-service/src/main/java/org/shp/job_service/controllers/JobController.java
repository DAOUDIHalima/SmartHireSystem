package org.shp.job_service.controllers;

import org.modelmapper.ModelMapper;
import org.shp.job_service.dtos.JobDto;
import org.shp.job_service.models.Job;
import org.shp.job_service.services.facade.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    private final JobService jobService;
    private final ModelMapper modelMapper;

    //injection par constructeur
    JobController(JobService jobService,
                  ModelMapper modelMapper){
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/")
    public ResponseEntity findAll() {
        try {
            List<JobDto> jobs = jobService.findAll();
            return jobs.isEmpty() ?
                    ResponseEntity.noContent().build()
                    :
                    ResponseEntity.ok(jobs);
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity findById(@PathVariable("id") long id) {
        try {
            JobDto job = jobService.findById(id);
            return job == null ?
                    ResponseEntity.noContent().build()
                    :
                    ResponseEntity.ok(modelMapper.map(job, JobDto.class));
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/bytitle/{title}")
    public ResponseEntity findByTitle(@PathVariable("title") String title) {
        try {
            List<JobDto> jobs = jobService.findByTitle(title);
            return jobs.isEmpty() ?
                    ResponseEntity.noContent().build()
                    :
                    ResponseEntity.ok(jobs);
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/bylocation/{location}")
    public ResponseEntity findByLocation(@PathVariable("location") String location) {
        try {
            List<JobDto> jobs = jobService.findByLocation(location);
            return jobs.isEmpty() ?
                    ResponseEntity.noContent().build()
                    :
                    ResponseEntity.ok(jobs);
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") long id) {
        try {
            jobService.deleteById(id);
            return ResponseEntity.ok("deleted");// message ...
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    // for update/save you can use the save same
    @PutMapping("/update")
    public ResponseEntity updateJob(@RequestBody JobDto jobDto) {
        try {
            Job job = modelMapper.map(jobDto, Job.class);
            return ResponseEntity.ok(modelMapper.map(jobService.updateJob(job), JobDto.class));// message ...
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody JobDto jobDto) {
        try {
            Job job = modelMapper.map(jobDto, Job.class);
            job = jobService.save(job);
            if (job == null) return null;
            return ResponseEntity.ok(modelMapper.map(job, JobDto.class));
        } catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
