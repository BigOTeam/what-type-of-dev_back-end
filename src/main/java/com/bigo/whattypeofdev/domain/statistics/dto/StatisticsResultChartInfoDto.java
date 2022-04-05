package com.bigo.whattypeofdev.domain.statistics.dto;

import com.bigo.whattypeofdev.global.entity.Answer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResultChartInfoDto {
    private List<String> contents;
    private List<Integer> count;
    private List<Integer> countPercent;

    @Builder
    private StatisticsResultChartInfoDto(List<String> contents, List<Integer> count, List<Integer> countPercent) {
        this.contents = contents;
        this.count = count;
        this.countPercent = countPercent;
    }

    public static StatisticsResultChartInfoDto converter(List<String> data,List<Integer> count){
        return StatisticsResultChartInfoDto
                .builder()
                .contents(data)
                .count(count)
                .count(count
                        .stream()
                        .map(c->c/count.stream().mapToInt(i->i).sum())
                        .collect(Collectors.toList()))
                .build();
    }
}
