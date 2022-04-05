package com.bigo.whattypeofdev.domain.statistics.controller;

import com.bigo.whattypeofdev.domain.statistics.dto.StatisticsResponseDto;
import com.bigo.whattypeofdev.domain.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StatisticsController {

        private final StatisticsService statisticsService;

        @GetMapping("statistics")
        public StatisticsResponseDto getStatistics(){
                StatisticsResponseDto statisticsResponseDto = statisticsService.getStatistics();
                return statisticsResponseDto;
        }

}
