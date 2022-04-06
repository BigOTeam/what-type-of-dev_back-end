package com.bigo.whattypeofdev.domain.statistics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ApiModel
public class StatisticsHeaderDto {
    @ApiModelProperty(name = "오늘 날짜")
    private String endDate;
    @ApiModelProperty(name = "통계 참여 인원수")
    private int userCount;
    @ApiModelProperty(name = "현업 개발자 수")
    private int careerCount;
    @ApiModelProperty(name = "비개발자 수")
    private int newCount;

    @Builder
    public StatisticsHeaderDto(String endDate, int userCount, int careerCount, int newCount) {
        this.endDate = endDate;
        this.userCount = userCount;
        this.careerCount = careerCount;
        this.newCount = newCount;
    }
}
