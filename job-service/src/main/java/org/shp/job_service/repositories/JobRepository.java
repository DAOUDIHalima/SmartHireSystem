package org.shp.job_service.repositories;

import org.shp.job_service.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findJobsByTitleIs(String title);

    List<Job> findJobsByLocation(String location);

    void deleteJobById(long id);

}
