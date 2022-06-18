package com.bigo.whattypeofdev.survey;


import com.bigo.whattypeofdev.domain.surveys.dto.*;
import com.bigo.whattypeofdev.domain.surveys.exception.SurveyNotFoundException;
import com.bigo.whattypeofdev.domain.surveys.service.SurveyService;
import com.bigo.whattypeofdev.domain.surveys.service.SurveyServiceImpl;
import com.bigo.whattypeofdev.global.entity.Occupation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("설문 기능 Test")
public class SurveyServiceTest {

    @Autowired
    SurveyServiceImpl surveyServiceImpl;

    @Test
    @DisplayName("Survey 질문 리스트 개수 비교")
    void getSurveyByPageNoTest(){
        long PageNo = 2;
        String isDeveloper= "true";

        SurveyResponseDto surveyResponseDtoForDev = surveyServiceImpl.getSurveyByPageNo(PageNo,isDeveloper);
        isDeveloper="false";
        SurveyResponseDto surveyResponseDtoForNonDev = surveyServiceImpl.getSurveyByPageNo(PageNo,isDeveloper);
        assertThat(surveyResponseDtoForDev.getSurveys().size()-surveyResponseDtoForNonDev.getSurveys().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Survey 질문 리스트 개발자용 질문 포함 여부 확인")
    void getSurveyByPageNoTestforDev(){
        long PageNo = 2;
        String isDeveloper = "true";
        SurveyResponseDto surveyResponseDtoForDev = surveyServiceImpl.getSurveyByPageNo(PageNo,isDeveloper);;
        assertThat(surveyResponseDtoForDev.getSurveys().get(0).getQuestionInitial()).isEqualTo("aboutme_dev_type");
    }

    @Test
    @DisplayName("직업 리스트 개수 확인")
    void getJobListTest(){
        JobListResponseDto jobList = surveyServiceImpl.getJobList();
        List<JobDto> jobs = jobList.getJobList();
        assertThat(jobs.size()).isSameAs(Occupation.values().length);
    }

    @Test
    @DisplayName("직업 정보 받기")
    void getJobInfoTest(){
        List<JobResponseDto> jobInfos = new ArrayList<>();
        for (int i = 1; i <= Occupation.values().length; i++) {
            jobInfos.add(surveyServiceImpl.getJobInfo((long)i));
        }
        List<String> names = jobInfos.stream().map(x->x.getJobName()).sorted().collect(Collectors.toList());
        List<String> occupationNames = Arrays.stream(Occupation.values()).map(x->x.getJobName()).sorted().collect(Collectors.toList());
        assertThat(names).isEqualTo(occupationNames);
    }

}
