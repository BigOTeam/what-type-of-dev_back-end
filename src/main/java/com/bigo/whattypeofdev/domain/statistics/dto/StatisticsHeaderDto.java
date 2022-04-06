package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class StatisticsHeaderDto {
    private String endDate;
    private int userCount;
    private int careerCount;
    private int newCount;

    @Builder
    public StatisticsHeaderDto(String endDate, int userCount, int careerCount, int newCount) {
        this.endDate = endDate;
        this.userCount = userCount;
        this.careerCount = careerCount;
        this.newCount = newCount;
    }
}
