package com.bigo.whattypeofdev.domain.statistics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@ApiModel
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResponseDto {
    @ApiModelProperty(name = "통계 헤더 Dto")
    private StatisticsHeaderDto header;
    @ApiModelProperty(name = "통계 내용 Dto")
    private List<StatisticsContentDto> contents;


    private StatisticsResponseDto(StatisticsHeaderDto header, List<StatisticsContentDto> contents) {
        this.header = header;
        this.contents = contents;
    }


    public static StatisticsResponseDto of(StatisticsHeaderDto header, List<StatisticsContentDto> content){
        return new StatisticsResponseDto(header,content);
    }
}
