package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StatisticsResultDto {
    private Long id;
    private String question;
    private String chartType;
    private List<StatisticsResultChartInfoDto> chartInfoData;

    @Builder
    public StatisticsResultDto(Long id, String question, String chartType, List<StatisticsResultChartInfoDto> chartInfoData) {
        this.id = id;
        this.question = question;
        this.chartType = chartType;
        this.chartInfoData = chartInfoData;
    }
}
