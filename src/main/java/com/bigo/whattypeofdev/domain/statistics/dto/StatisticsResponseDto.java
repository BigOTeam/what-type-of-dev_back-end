package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Getter;

@Getter
public class StatisticsResponseDto {
    private StatisticsHeaderDto header;
    private StatisticsContentDto contents;


    private StatisticsResponseDto(StatisticsHeaderDto header, StatisticsContentDto contents) {
        this.header = header;
        this.contents = contents;
    }

    public static StatisticsResponseDto of(StatisticsHeaderDto header, StatisticsContentDto content){
        return new StatisticsResponseDto(header,content);
    }
}
