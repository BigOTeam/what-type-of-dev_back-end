package com.bigo.whattypeofdev.domain.surveys.controller;

import com.bigo.whattypeofdev.domain.surveys.dto.JobResponseDto;
import com.bigo.whattypeofdev.domain.surveys.dto.JobListResponseDto;
import com.bigo.whattypeofdev.domain.surveys.dto.SurveyResponseDto;
import com.bigo.whattypeofdev.domain.surveys.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class SurveyController {

    private final SurveyService surveyService;
    @GetMapping("surveys")
    public SurveyResponseDto getSurvey(@RequestParam("pageNo") Long pageNo,@RequestParam("isDeveloper") String isDeveloper){
        SurveyResponseDto surveyResponseDto = surveyService.getSurveybyPageNo(pageNo,isDeveloper);
        return surveyResponseDto;
    }
    @GetMapping("surveys/jobs")
    public JobListResponseDto getJobList(){
        return surveyService.getJobList();
    }

    @GetMapping("surveys/jobs/{job_id}")
    public JobResponseDto getJobInfo(@PathVariable("job_id") Long jobId){
        return surveyService.getJobInfo(jobId);
    }

}
