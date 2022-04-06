package com.bigo.whattypeofdev.domain.statistics.dto;

import com.bigo.whattypeofdev.global.entity.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@ApiModel
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResultDto {
    @ApiModelProperty(name = "통계 결과 id")
    private Long id;
    @ApiModelProperty(name = "질문")
    private String question;
    @ApiModelProperty(name = "차트 타입",example = "doughnut")
    private String chartType;
    @ApiModelProperty(name = "차트 데이터")
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
