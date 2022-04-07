package com.bigo.whattypeofdev.domain.statistics.repository;

import com.bigo.whattypeofdev.global.entity.SurveyRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurveyRecordRepository extends JpaRepository<SurveyRecord,Long>,SurveyRecordCustumRepository{
    int countByAboutmeDev(int answer_seq);
    int countByLifeJob(int answer_seq);
    int countByLifeGood(int i);
    int countByAboutmeMobile(int i);
}
