package com.bigo.whattypeofdev.domain.surveys.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class JobListResponseDto {
    private final List<JobDto> jobList;
}
