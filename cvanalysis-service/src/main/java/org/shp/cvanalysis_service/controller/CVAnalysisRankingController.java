package org.shp.cvanalysis_service.controller;

import org.shp.cvanalysis_service.dtos.CandidateDto;
import org.shp.cvanalysis_service.dtos.JobDto;
import org.shp.cvanalysis_service.dtos.RankingResultDto;
import org.shp.cvanalysis_service.models.CVAnalysisResult;
import org.shp.cvanalysis_service.services.impl.CVAnalysisService;
import org.shp.cvanalysis_service.services.impl.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/analysis")
public class CVAnalysisRankingController {

    private  CVAnalysisService cvAnalysisService;
    private  RankingService rankingService;

    @Autowired
    public CVAnalysisRankingController(CVAnalysisService cvAnalysisService, RankingService rankingService) {
        this.cvAnalysisService = cvAnalysisService;
        this.rankingService = rankingService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<RankingResultDto> analyzeAndRank(@RequestParam("cvFilePath") String cvFilePath,
                                                           @RequestBody CandidateDto candidateDto,
                                                           @RequestBody JobDto jobDto) {
        // Analyze the CV
        CVAnalysisResult analysisResult = cvAnalysisService.analyzeCV(cvFilePath);

        // Rank the candidate for the job
        RankingResultDto rankingResult = rankingService.rankCandidate(candidateDto, analysisResult, jobDto);

        return ResponseEntity.ok(rankingResult);
    }


}
