package com.bigo.whattypeofdev.domain.surveys.service;

import com.bigo.whattypeofdev.domain.surveys.dto.JobListResponseDto;
import com.bigo.whattypeofdev.domain.surveys.dto.JobResponseDto;
import com.bigo.whattypeofdev.domain.surveys.dto.SurveyResponseDto;

public interface SurveyService {
    SurveyResponseDto getSurveyByPageNo(Long pageNo, String isDeveloper);
    JobListResponseDto getJobList();
    JobResponseDto getJobInfo(Long jobId);
}
