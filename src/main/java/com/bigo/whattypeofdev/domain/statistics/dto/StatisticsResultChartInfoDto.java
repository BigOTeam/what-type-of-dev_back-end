package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StatisticsResultChartInfoDto {
    private List<String> contents;
    private List<Integer> count;
    private List<Integer> countPercent;

    @Builder
    public StatisticsResultChartInfoDto(List<String> contents, List<Integer> count, List<Integer> countPercent) {
        this.contents = contents;
        this.count = count;
        this.countPercent = countPercent;
    }
}
