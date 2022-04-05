package com.bigo.whattypeofdev.domain.statistics.service;


import com.bigo.whattypeofdev.domain.statistics.dto.*;
import com.bigo.whattypeofdev.domain.statistics.repository.StatisticGroupRepository;
import com.bigo.whattypeofdev.domain.statistics.repository.SurveyRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class StatisticsService {

    private final SurveyRecordRepository surveyRecordRepository;
    private final StatisticGroupRepository statisticGroupRepository;

    public StatisticsHeaderDto getStatisticsHeader(){
        int userCount = (int)surveyRecordRepository.count();
        //개발자 묻는 질문 답변 받기
        //답변 예 : 1 아니오 : 2
        int careerCount = (int)surveyRecordRepository.countByAboutmeDev(1);
        return StatisticsHeaderDto
                .builder()
                .endDate(LocalDateTime.now())
                .userCount(userCount)
                .careerCount(careerCount)
                .newCount(userCount-careerCount)
                .build();
    }

    public StatisticsResponseDto getStatistics(){
        return StatisticsResponseDto.of(getStatisticsHeader(),getStatisticsContent());
    }
    public List<StatisticsContentDto> getStatisticsContent() {
        return statisticGroupRepository.findAll()
                                        .stream()
                                        .map(statisticGroup-> StatisticsContentDto
                                                .converter(
                                                    statisticGroup,
                                                    StatisticsGroupTotalDescription
                                                            .valueOf(statisticGroup
                                                                    .getStatisticName())
                                                            .toList(),
                                                    statisticGroup
                                                            .getQuestionList()
                                                            .stream()
                                                            .map(question
                                                                    -> StatisticsResultDto
                                                                        .converter(
                                                                                question,
                                                                                StatisticsResultChartInfoDto
                                                                                        .converter(
                                                                                                surveyRecordRepository
                                                                                                        .findTop3ByColumn(question.getQuestionInitial()),
                                                                                                surveyRecordRepository
                                                                                                        .findTop3countByColumn(question.getQuestionInitial())
                                                                                                )
                                                                        )
                                                            )
                                                            .collect(Collectors.toList())
                                                )
                                        ).collect(Collectors.toList());
    }
}
