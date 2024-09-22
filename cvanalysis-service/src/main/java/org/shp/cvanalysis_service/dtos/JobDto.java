package org.shp.cvanalysis_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String companyName;
    private String employmentType;
    private String salaryRange;
    private List<String> requirements;
    private List<String> responsibilities;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private List<String> skills;
    private String experienceLevel;
    private String industry;
    private List<String> benefits;
    private String educationLevel;
}
