package com.bigo.whattypeofdev.domain.surveys.controller;

import com.bigo.whattypeofdev.domain.surveys.dto.JobResponseDto;
import com.bigo.whattypeofdev.domain.surveys.dto.JobListResponseDto;
import com.bigo.whattypeofdev.domain.surveys.dto.SurveyResponseDto;
import com.bigo.whattypeofdev.domain.surveys.service.SurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(value = "설문지 API", tags = {"Surveys"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("surveys")
    @ApiOperation(value = "설문 문항 보기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "파라미터에 해당하는 데이터를 찾을 수 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public SurveyResponseDto getSurvey(@RequestParam("pageNo") Long pageNo,@RequestParam(value = "isDeveloper",required = false) String isDeveloper){
        SurveyResponseDto surveyResponseDto = surveyService.getSurveybyPageNo(pageNo,isDeveloper);
        return surveyResponseDto;
    }

    @GetMapping("surveys/jobs")
    @ApiOperation(value = "직업 전체 유형 보기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public JobListResponseDto getJobList(){
        return surveyService.getJobList();
    }

    @GetMapping("surveys/jobs/{job_id}")
    @ApiOperation(value = "직업 유형별 상세보기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "파라미터에 해당하는 데이터를 찾을 수 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public JobResponseDto getJobInfo(@PathVariable("job_id") Long jobId){
        return surveyService.getJobInfo(jobId);
    }

}
