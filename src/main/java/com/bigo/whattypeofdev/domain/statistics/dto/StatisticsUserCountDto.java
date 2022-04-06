package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StatisticsUserCountDto {
    private static int responseUserCount;

    private StatisticsUserCountDto(int responseUserCount) {
        this.responseUserCount= responseUserCount;
    }

    public StatisticsUserCountDto from(int responseUserCount){
        return new StatisticsUserCountDto(responseUserCount);
    }
}
