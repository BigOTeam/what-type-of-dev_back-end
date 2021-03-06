package com.bigo.whattypeofdev.domain.statistics.controller;

import com.bigo.whattypeofdev.domain.statistics.exception.StatisticsParameterException;
import com.bigo.whattypeofdev.domain.statistics.dto.StatisticsResponseDto;
import com.bigo.whattypeofdev.domain.statistics.dto.StatisticsResultChartInfoDto;
import com.bigo.whattypeofdev.domain.statistics.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "통계 API", tags = {"Statistics"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StatisticsController {

        private final StatisticsService statisticsService;

        @GetMapping("statistics")
        @ApiOperation(value = "통계 결과 보기")
        @ApiResponses({
                @ApiResponse(code = 200, message = "성공"),
                @ApiResponse(code = 400, message = "파라미터에 해당하는 데이터를 찾을 수 없음"),
                @ApiResponse(code = 500, message = "서버 오류")
        })
        public StatisticsResponseDto getStatistics(){
                StatisticsResponseDto statisticsResponseDto = statisticsService.getStatistics();
                return statisticsResponseDto;
        }

        @GetMapping("statistics/filter")
        @ApiOperation(value = "설문 결과를 바탕으로 필터(연령대, 성별) 걸러서 모든 유형 순위대로 보여주기")
        @ApiResponses({
                @ApiResponse(code = 200, message = "성공"),
                @ApiResponse(code = 400, message = "파라미터에 해당하는 데이터를 찾을 수 없음"),
                @ApiResponse(code = 500, message = "서버 오류")
        })
        public StatisticsResultChartInfoDto getStatisticswithFilter(@RequestParam(name="gender")String gender,@RequestParam(name="age")String age){
                if(gender.isEmpty() || age.isEmpty()){
                        throw new StatisticsParameterException("필터 값이 비어있어 요청을 반영할 수 없습니다.");
                }
                return statisticsService.getStatisticswithFilter(gender,age);
        }

        @ApiOperation(value = "전체 응답자 수")
        @ApiResponses({
                @ApiResponse(code = 200, message = "성공"),
                @ApiResponse(code = 400, message = "파라미터에 해당하는 데이터를 찾을 수 없음"),
                @ApiResponse(code = 500, message = "서버 오류")
        })
        @GetMapping("statistics/count")
        public  Map<String,Integer> getUserCount() {
                Map<String, Integer> statisticsUserCount = new HashMap<>();
                int responseUserCount = statisticsService.getSurveyRecordCount();
                statisticsUserCount.put("responseUserCount", responseUserCount);
                return statisticsUserCount;
        }
}
