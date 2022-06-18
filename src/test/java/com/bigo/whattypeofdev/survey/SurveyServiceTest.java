package com.bigo.whattypeofdev.survey;


import com.bigo.whattypeofdev.domain.surveys.dto.SurveyResponseDto;
import com.bigo.whattypeofdev.domain.surveys.service.SurveyServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SurveyServiceTest {

    @Autowired
    SurveyServiceImpl surveyServiceImpl;
    @Test
    @DisplayName("개발자와 비개발자의 질문리스트 비교")
    void getSurveyByPageNoTest(){
        long PageNo = 2;
        String isDeveloper= "true";

        SurveyResponseDto surveyResponseDtoForDev = surveyServiceImpl.getSurveyByPageNo(PageNo,isDeveloper);
        isDeveloper="false";
        SurveyResponseDto surveyResponseDtoForNonDev = surveyServiceImpl.getSurveyByPageNo(PageNo,isDeveloper);
        assertThat(surveyResponseDtoForDev.getSurveys().size()-surveyResponseDtoForNonDev.getSurveys().size()).isEqualTo(1);
    }

}
