package com.bigo.whattypeofdev.domain.statistics.dto;

import com.bigo.whattypeofdev.global.entity.Question;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResultDto {
    private Long id;
    private String question;
    private String chartType;
    private StatisticsResultChartInfoDto chartInfoData;

    @Builder
    private StatisticsResultDto(Long id, String question, String chartType, StatisticsResultChartInfoDto chartInfoData) {
        this.id = id;
        this.question = question;
        this.chartType = chartType;
        this.chartInfoData = chartInfoData;
    }

    public static StatisticsResultDto converter(Question question, StatisticsResultChartInfoDto statisticsResultChartInfoDto){
        return StatisticsResultDto.builder()
                .id(question.getQuestionId())
                .question(question.getQuestion())
                .chartType(question.getChartType())
                .chartInfoData(statisticsResultChartInfoDto)
                .build();
    }

}
