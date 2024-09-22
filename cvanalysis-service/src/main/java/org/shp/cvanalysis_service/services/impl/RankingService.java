package org.shp.cvanalysis_service.services.impl;

import org.shp.cvanalysis_service.dtos.CandidateDto;
import org.shp.cvanalysis_service.dtos.JobDto;
import org.shp.cvanalysis_service.dtos.RankingResultDto;
import org.shp.cvanalysis_service.models.CVAnalysisResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RankingService {

    public RankingResultDto rankCandidate(CandidateDto candidateDto, CVAnalysisResult analysisResult, JobDto jobDto) {
        // Implement custom ranking logic based on candidate attributes and job requirements
        double rankingScore = calculateRelevanceScore(candidateDto, analysisResult, jobDto);

        // Return the ranking result
        return new RankingResultDto(candidateDto.getId(), candidateDto.getCurrentJobTitle(), rankingScore);
    }

    public List<RankingResultDto> getRankingsForJob(Long jobId) {
        // Implement retrieval of ranking results for a given job from a database or repository
        return List.of(
                new RankingResultDto(1L, "John Doe", 85.5),
                new RankingResultDto(2L, "Jane Smith", 92.0)
        );
    }

    private double calculateRelevanceScore(CandidateDto candidateDto, CVAnalysisResult analysisResult, JobDto jobDto) {
        // Example scoring algorithm: Match skills, experience, and education
        double score = 0;

        // Skill matching (e.g., 50% of the score)
        double skillMatchScore = calculateSkillMatch(analysisResult.getSkills(), jobDto.getSkills());
        score += skillMatchScore * 0.5;

        // Experience matching (e.g., 30% of the score)
        double experienceScore = calculateExperienceMatch(analysisResult.getExperienceYears(), jobDto.getExperienceLevel());
        score += experienceScore * 0.3;

        // Education matching (e.g., 20% of the score)
        double educationScore = calculateEducationMatch(analysisResult.getEducationLevel(), jobDto.getEducationLevel());
        score += educationScore * 0.2;

        return score;
    }

    // Example methods for calculating different match scores
    private double calculateSkillMatch(Set<String> candidateSkills, List<String> jobSkills) {
        // Implement skill matching logic here
        return 90.0; // Example: 90% skill match
    }

    private double calculateExperienceMatch(int candidateExperience, String jobExperienceLevel) {
        // Implement experience matching logic here
        return 80.0; // Example: 80% experience match
    }

    private double calculateEducationMatch(String candidateEducation, String jobEducationLevel) {
        // Implement education level matching logic here
        return 75.0; // Example: 75% education match
    }
}
