package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class StatisticsHeaderDto {
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime endDate;
    private int userCount;
    private int careerCount;
    private int newCount;

    @Builder
    public StatisticsHeaderDto(LocalDateTime endDate, int userCount, int careerCount, int newCount) {
        this.endDate = endDate;
        this.userCount = userCount;
        this.careerCount = careerCount;
        this.newCount = newCount;
    }
}
