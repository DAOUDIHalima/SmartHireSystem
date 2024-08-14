package org.shp.application_service.dtos;

import java.time.LocalDateTime;

public class ApplicationDto {
    private Long id;
    private String applicantName;
    private String applicantEmail;
    private Long jobId;
    private LocalDateTime appliedAt;
    private String cvPath;

    private String status;

}
