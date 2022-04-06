package com.bigo.whattypeofdev.domain.statistics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@ApiModel
@RequiredArgsConstructor
public class StatisticsUserCountDto {
    @ApiModelProperty(name = "전체 응답자 수")
    private static int responseUserCount;

    private StatisticsUserCountDto(int responseUserCount) {
        this.responseUserCount= responseUserCount;
    }

    public StatisticsUserCountDto from(int responseUserCount){
        return new StatisticsUserCountDto(responseUserCount);
    }
}
