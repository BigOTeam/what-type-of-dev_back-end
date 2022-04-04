package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Getter;

@Getter
public class StatisticsResponse {
    private StatisticsHeaderDto header;
    private StatisticsContentDto contents;


    private StatisticsResponse(StatisticsHeaderDto header, StatisticsContentDto contents) {
        this.header = header;
        this.contents = contents;
    }

    public static StatisticsResponse of(StatisticsHeaderDto header, StatisticsContentDto content){
        return new StatisticsResponse(header,content);
    }
}
