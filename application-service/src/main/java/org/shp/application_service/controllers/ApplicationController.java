package org.shp.application_service.controllers;

import org.shp.application_service.dtos.ApplicationDto;
import org.shp.application_service.models.Application;
import org.shp.application_service.services.facade.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public List<ApplicationDto> findById(@PathVariable("id") String id) {
        List<Application> applications = applicationService.findById(Long.valueOf(id));
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        for (Application application : applications) {
            ApplicationDto applicationDto = modelMapper.map(application, ApplicationDto.class);
            applicationDtos.add(applicationDto);

        }
       return applicationDtos;
    }

    @GetMapping("/id/{id}")
    public void deleteApplicationById(@PathVariable("id") String id) {
        applicationService.deleteByJobId(Long.valueOf(id));
    }

    @GetMapping
    public List<ApplicationDto> findByApplicantName(String name) {
        List<Application> applications = applicationService.findByApplicantName(name);
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        for (Application application : applications) {
            ApplicationDto applicationDto = modelMapper.map(application, ApplicationDto.class);
            applicationDtos.add(applicationDto);
        }
        return applicationDtos;
    }


}
