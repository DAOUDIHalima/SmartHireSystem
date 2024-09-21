package org.shp.user_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "hiring_managers")
public class HiringManager extends User {

    @Column(name = "department")
    private String department;

    @ElementCollection
    @CollectionTable(name = "manager_job_listings", joinColumns = @JoinColumn(name = "manager_id"))
    @Column(name = "job_listing_id")
    private Set<Long> managedJobListings = new HashSet<>(); // or a reference to a Job entity

    @Column(name = "company")
    private String company;


    @Column(name = "position_level")
    private String positionLevel; // For example, 'Junior', 'Senior', 'Executive'


    @Column(name = "location")
    private String location;

    @Column(name = "linkedin_profile")
    private String linkedinProfile;

    @Column(name = "open_positions")
    private int openPositions;

    //@Column(name = "recruitment_pipeline")
    //private String recruitmentPipeline;

    //@Column(name = "hiring_targets")
    //private String hiringTargets;

    @Column(name = "company_size")
    private int companySize;

    @Column(name = "hiring_experience_years")
    private int hiringExperienceYears;

}
