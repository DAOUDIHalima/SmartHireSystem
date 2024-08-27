package org.shp.job_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "employmentType")
    private String employmentType;
    @Column(name = "salaryRange")
    private Long salaryRange;
    @ElementCollection
    @CollectionTable(name = "job_requirements", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "requirement")
    private List<String> requirements;
    @Column(name = "created_at")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "status")
    private String status;// Full-Time, Part-Time, etc.
    @Column(name = "experience_level")
    private String experienceLevel;
    @Column(name = "education_level")
    private String educationLevel;
    @ElementCollection
    private List<String> skills;




}
