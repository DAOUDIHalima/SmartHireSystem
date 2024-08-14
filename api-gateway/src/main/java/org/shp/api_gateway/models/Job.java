package org.shp.api_gateway.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Job {

    private long id;
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
    //User
    private String createdBy;
    private String status;
    private List<String> skills;
    private String experienceLevel;
    private String educationLevel;



}
