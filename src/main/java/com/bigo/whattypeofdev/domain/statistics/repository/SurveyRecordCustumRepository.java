package com.bigo.whattypeofdev.domain.statistics.repository;


import java.util.List;

public interface SurveyRecordCustumRepository {
    List<Integer> findAllTopcountByColumn(String column);
    List<String> findAllTopByColumn(String column);
    String findTopByColumn(String column);
    int countByColumn(String column);
}
