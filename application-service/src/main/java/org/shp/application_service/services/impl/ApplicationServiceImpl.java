package org.shp.application_service.services.impl;

import org.shp.application_service.models.Application;
import org.shp.application_service.repositories.ApplicationRepository;
import org.shp.application_service.services.facade.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public List<Application> findById(long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public List<Application> findByApplicantName(String applicantName) {
        return applicationRepository.findByApplicantName(applicantName);
    }

    @Override
    public void deleteByJobId(Long id) {
        applicationRepository.deleteByJobId(id);
    }
}
