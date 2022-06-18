package com.bigo.whattypeofdev.survey;


import com.bigo.whattypeofdev.domain.surveys.exception.SurveyNotFoundException;
import com.bigo.whattypeofdev.domain.surveys.repository.SurveyRepository;
import com.bigo.whattypeofdev.global.entity.Page;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    @DisplayName("설문지 받아오기")
    void 설문지체크(){
        long pageNo = 2;
        Page page = surveyRepository
                .findById(pageNo)
                .orElseThrow(()-> new SurveyNotFoundException("pageNo에 해당하는 Survey 데이터를 찾을 수 없습니다."));
        System.out.println("page.getPageDescription() = " + page.getPageName());
        Assertions.assertThat(page.getPageName()).isNotEmpty();
    }

}
