package org.shp.application_service.services.facade;


import org.shp.application_service.models.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> findById(long id);

    List<Application> findByApplicantName(String name);

    void deleteByJobId(Long jobId);

}
