package org.shp.cvanalysis_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CVAnalysisResult {
    private Set<String> skills;
    private int experienceYears;
    private String educationLevel;
    private String location;


}

