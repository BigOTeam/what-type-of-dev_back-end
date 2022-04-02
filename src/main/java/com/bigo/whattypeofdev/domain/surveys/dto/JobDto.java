package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.Job;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JobDto {
    private Long jobId;
    private String jobName;
    private String jobImg;

    @Builder
    public JobDto(Long jobId, String jobName, String jobImg) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobImg = jobImg;
    }

    public static JobDto fromEntity(Job job){
        return JobDto.builder()
                .jobId(job.getJobId())
                .jobName(job.getJobName().getJobName())
                .jobImg(job.getJobImg())
                .build();
    }
}
