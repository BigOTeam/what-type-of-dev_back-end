package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.Job;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@ApiModel
public class JobDto {
    @ApiModelProperty(name="직업 id", example = "1")
    private Long jobId;
    @ApiModelProperty(name="직업 이름", example = "웹개발자")
    private String jobName;
    @ApiModelProperty(name="직업 이미지", example = "https://~")
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
