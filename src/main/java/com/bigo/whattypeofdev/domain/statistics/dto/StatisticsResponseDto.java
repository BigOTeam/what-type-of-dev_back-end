package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResponseDto {
    private StatisticsHeaderDto header;
    private List<StatisticsContentDto> contents;


    private StatisticsResponseDto(StatisticsHeaderDto header, List<StatisticsContentDto> contents) {
        this.header = header;
        this.contents = contents;
    }


    public static StatisticsResponseDto of(StatisticsHeaderDto header, List<StatisticsContentDto> content){
        return new StatisticsResponseDto(header,content);
    }
}
