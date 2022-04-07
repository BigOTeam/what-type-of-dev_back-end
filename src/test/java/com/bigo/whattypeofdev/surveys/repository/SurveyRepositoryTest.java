package com.bigo.whattypeofdev.surveys.repository;

import com.bigo.whattypeofdev.domain.surveys.repository.SurveyRepository;
import com.bigo.whattypeofdev.global.entity.Job;
import com.bigo.whattypeofdev.global.entity.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SurveyRepositoryTest {
    @Autowired
    SurveyRepository repository;

    @Test
    void 직업전체반환() {
        List<Page> pages = repository.findAll();

        for (Page p : pages) {
            System.out.println(p.getPageName());
        }
    }

}
