package org.shp.user_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CandidateDto  extends UserDto{

    private String cvFilePath;
    private Set<String> skills = new HashSet<>();
    private int experienceYears;
    private String educationLevel;
    private String jobPreferences;
    private String currentJobTitle;
    private String linkedinProfile;
    private String portfolio;
    private String location;
    private String status;
    private BigDecimal expectedSalary;
    private String languagesSpoken;
    private LocalDate availability;


}
