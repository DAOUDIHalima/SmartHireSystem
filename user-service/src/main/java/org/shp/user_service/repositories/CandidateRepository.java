package org.shp.user_service.repositories;

import org.shp.user_service.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
        Optional<Candidate> findById(Long id);

}
