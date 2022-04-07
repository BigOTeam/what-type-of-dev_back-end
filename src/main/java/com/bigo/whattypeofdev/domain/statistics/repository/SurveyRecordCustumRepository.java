package com.bigo.whattypeofdev.domain.statistics.repository;


import java.util.List;

public interface SurveyRecordCustumRepository {
    List<Integer> findAllTopcountByColumn(String column);
    List<String> findAllTopByColumn(String column);
    String findTopByColumn(String column);
    int countAll(String column);
    List<Integer> findAllcountByColumnWithFilter(String column, int gender, int age);
    List<String> findAllByColumnWithFilter(String column, int gender, int age);
    List<String> findAllByColumn(String column);
    List<Integer> findAllCountByColumn(String column);
}

