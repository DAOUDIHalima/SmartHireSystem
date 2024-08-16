package org.shp.job_service.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    private Long salaryRange;
    private List<String> requirements;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedAt;
    private String createdBy;
    private String status;
    private String experienceLevel;
    private String educationLevel;
    private List<String> skills;

}

