package com.bigo.whattypeofdev.domain.statistics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ApiModel
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResultChartInfoDto {
    @ApiModelProperty(name = "답변")
    private List<String> contents;
    @ApiModelProperty(name = "답변당 선택한 사람 수")
    private List<Integer> count;
    @ApiModelProperty(name = "답변당 선택한 사람 비율")
    private List<Integer> countPercent;

    @Builder
    private StatisticsResultChartInfoDto(List<String> contents, List<Integer> count, List<Integer> countPercent) {
        this.contents = contents;
        this.count = count;
        this.countPercent = countPercent;
    }

    public static StatisticsResultChartInfoDto converter(List<String> data,List<Integer> count,int totalcount){
        return StatisticsResultChartInfoDto
                .builder()
                .contents(data)
                .count(count)
                .countPercent(count
                        .stream()
                        .map(c->(c*100/totalcount))
                        .collect(Collectors.toList()))
                .build();
    }
}
