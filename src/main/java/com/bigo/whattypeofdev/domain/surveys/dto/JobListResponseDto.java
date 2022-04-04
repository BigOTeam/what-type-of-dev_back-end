package com.bigo.whattypeofdev.domain.surveys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@ApiModel
public class JobListResponseDto {
    @ApiModelProperty(name="직업 목록")
    private final List<JobDto> jobList;
}
