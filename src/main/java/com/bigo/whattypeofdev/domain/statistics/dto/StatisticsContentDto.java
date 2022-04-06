package com.bigo.whattypeofdev.domain.statistics.dto;

import com.bigo.whattypeofdev.global.entity.StatisticGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@ApiModel
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsContentDto {
    @ApiModelProperty(name = "그룹 id")
    private Long groupId;
    @ApiModelProperty(name = "그룹 이름")
    private String groupName;
    @ApiModelProperty(name = "그룹 설명")
    private String description;
    @ApiModelProperty(name = "그룹 이미지")
    private String groupImg;
    @ApiModelProperty(name = "통계 분석 내용")
    private List<String> summaryInfos;
    @ApiModelProperty(name = "차트 결과 리스트")
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
                .summaryInfos(totalDescription.subList(1,4))
                .description(totalDescription.get(0))
                .results(results)
                .build();
    }
}
