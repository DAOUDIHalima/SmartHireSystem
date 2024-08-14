package org.shp.application_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String applicantName;
    private String applicantEmail;
    private Long jobId;  // Reference to the job the application is for
    private LocalDateTime appliedAt;
    private String cvPath;

    private String status;  // e.g., PENDING, APPROVED, REJECTED


}
