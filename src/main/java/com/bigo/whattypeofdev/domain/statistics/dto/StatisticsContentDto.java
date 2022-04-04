package com.bigo.whattypeofdev.domain.statistics.dto;

import com.bigo.whattypeofdev.global.entity.StatisticGroup;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StatisticsContentDto {
    private Long groupId;
    private String groupName;
    private String description;
    private String imageUrl;
    private List<String> summaryInfo;
    private List<StatisticsResultDto> result;

    @Builder
    public StatisticsContentDto(Long groupId, String groupName, String description, String imageUrl, List<String> summaryInfo, List<StatisticsResultDto> result) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.summaryInfo = summaryInfo;
        this.result = result;
    }

}
