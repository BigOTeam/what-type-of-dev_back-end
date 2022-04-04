package com.bigo.whattypeofdev.domain.statistics.repository;

import com.bigo.whattypeofdev.global.entity.SurveyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRecordRepository extends JpaRepository<SurveyRecord,Long> {
}
