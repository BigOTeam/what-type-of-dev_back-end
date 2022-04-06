package com.bigo.whattypeofdev.domain.statistics.controller;

import com.bigo.whattypeofdev.domain.statistics.dto.StatisticsResponseDto;
import com.bigo.whattypeofdev.domain.statistics.dto.StatisticsResultChartInfoDto;
import com.bigo.whattypeofdev.domain.statistics.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        @GetMapping("statistics/filter")
        public StatisticsResultChartInfoDto getStatisticswithFilter(@RequestParam(name="gender")String gender,@RequestParam(name="age")String age){
                return statisticsService.getStatisticswithFilter(gender,age);
        }

        @GetMapping("statistics/count")
        public  Map<String,Integer> getUserCount(){
                Map<String,Integer> statisticsUserCount = new HashMap<>();
                int responseUserCount = statisticsService.getSurveyRecordCount();
                statisticsUserCount.put("responseUserCount",responseUserCount);
                return statisticsUserCount;
        }
}
