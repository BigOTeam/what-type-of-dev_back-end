package com.bigo.whattypeofdev.domain.statistics.dto;

import com.bigo.whattypeofdev.global.entity.StatisticGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsContentDto {
    private Long groupId;
    private String groupName;
    private String description;
    private String groupImg;
    private List<String> summaryInfos;
    private List<StatisticsResultDto> results;

    @Builder
    private StatisticsContentDto(Long groupId, String groupName, String description, String groupImg, List<String> summaryInfos, List<StatisticsResultDto> results) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
        this.groupImg = groupImg;
        this.summaryInfos = summaryInfos;
        this.results = results;
    }


    public static StatisticsContentDto converter(StatisticGroup statisticGroup,List<String> totalDescription,List<StatisticsResultDto> results){
        return StatisticsContentDto.builder()
                .groupId(statisticGroup.getStatisticId())
                .groupName(statisticGroup.getStatisticName())
                .groupImg(statisticGroup.getStatisticImg())
                .summaryInfos(totalDescription.subList(1,3))
                .description(totalDescription.get(0))
                .results(results)
                .build();
    }
}
