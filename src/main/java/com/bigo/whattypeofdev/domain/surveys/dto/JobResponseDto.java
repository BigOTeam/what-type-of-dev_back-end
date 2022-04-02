package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.Job;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JobResponseDto {
    private Long jobId;
    private String jobName;
    private String jobImgUrl;
    private String jobDescription;

    @Builder
    public JobResponseDto(Long jobId, String jobName, String jobImgUrl, String jobDescription) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobImgUrl = jobImgUrl;
        this.jobDescription = jobDescription;
    }

    public static JobResponseDto fromEntity(Job job){
        return JobResponseDto.builder()
                .jobId(job.getJobId())
                .jobName(job.getJobName().getJobName())
                .jobImgUrl(job.getJobImg())
                .jobDescription(job.getJobDescription())
                .build();
    }
}
