package org.shp.user_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "candidates")
public class Candidate extends User {

    @Column(name = "cv_file_path")
    private String cvFilePath;

    @ElementCollection
    @CollectionTable(name = "candidate_skills", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "skill")
    private Set<String> skills = new HashSet<>();

    @Column(name = "experience_years")
    private int experienceYears;

    @Column(name = "education_level")
    private String educationLevel;

    @Column(name = "job_preferences")
    private String jobPreferences;

    @Column(name = "current_job_title")
    private String currentJobTitle;

    @Column(name = "linkedin_profile")
    private String linkedinProfile;

    @Column(name = "portfolio")
    private String portfolio;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private String status; // For example, 'Actively Looking', 'Open to Offers', 'Not Looking'

    @Column(name = "expected_salary")
    private BigDecimal expectedSalary;

    @Column(name = "languages_spoken")
    private String languagesSpoken;

    @Column(name = "availability")
    private LocalDate availability;

}


