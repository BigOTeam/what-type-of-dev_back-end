package com.bigo.whattypeofdev.domain.surveys.service;

import com.bigo.whattypeofdev.domain.surveys.dto.*;
import com.bigo.whattypeofdev.domain.surveys.exception.SurveyNotFoundException;
import com.bigo.whattypeofdev.domain.surveys.repository.JobRepository;
import com.bigo.whattypeofdev.domain.surveys.repository.SurveyRepository;
import com.bigo.whattypeofdev.global.entity.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final JobRepository jobRepository;

    public SurveyResponseDto getSurveybyPageNo(Long pageNo,String isDeveloper){
        Page page = surveyRepository.findById(pageNo).orElseThrow(()-> new SurveyNotFoundException("pageNo에 해당하는 Survey를 찾을 수 없습니다."));
        List<SurveyInfoDto> surveyInfoDtos = page.getQuestionList().stream().map(o->
                                                    SurveyInfoDto.builder()
                                                            .questionInitial(o.getQuestionInitial())
                                                            .question(o.getQuestion())
                                                            .answers(o.getQuestionAnswerList().stream().map(AnswerDto::fromEntity).collect(Collectors.toList()))
                                                            .build())
                                                    .collect(Collectors.toList());
        if(pageNo==2&&!isDeveloper.equals("true")){
            surveyInfoDtos.remove(0);
        }
        return SurveyResponseDto.fromEntitywithSurveyInfoDto(page,surveyInfoDtos);
    }

    public JobListResponseDto getJobList(){
        List<JobDto> jobs = jobRepository.findAll().stream().map(JobDto::fromEntity).collect(Collectors.toList());
        return new JobListResponseDto(jobs);
    }

    public JobResponseDto getJobInfo(Long jobId) {
        return JobResponseDto.fromEntity(jobRepository.findById(jobId)
                                        .orElseThrow(()-> new SurveyNotFoundException("jobId에 해당하는 job 데이터를 찾을 수 없습니다.")));
    }
}
