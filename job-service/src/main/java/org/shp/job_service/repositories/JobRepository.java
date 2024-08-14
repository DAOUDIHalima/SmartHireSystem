package org.shp.job_service.repositories;

import org.shp.job_service.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    public Job findById(long id);

    public List<Job> findByTitle(String title);

    public List<Job> findByLocation(String location);

    public void deleteById(long id);

    public Job updateById(long id);

    public Job save(Job job);

}
