package com.bigo.whattypeofdev.domain.surveys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@ApiModel
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class JobListResponseDto {
    @ApiModelProperty(name="직업 목록")
    private List<JobDto> jobList;

    private JobListResponseDto(List<JobDto> jobList) {
        this.jobList = jobList;
    }

    public static JobListResponseDto from(List<JobDto> jobList){
        return new JobListResponseDto(jobList);
    }
}
