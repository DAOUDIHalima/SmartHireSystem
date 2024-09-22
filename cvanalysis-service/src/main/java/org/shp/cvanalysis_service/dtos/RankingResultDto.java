package org.shp.cvanalysis_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RankingResultDto {
    private Long candidateId;
    private String candidateName;
    private double rankingScore;
}
