package org.shp.application_service.repositories;


import org.shp.application_service.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findById(long id);

    List<Application> findByApplicantName(String name);

    void deleteByJobId(Long jobId);





}
