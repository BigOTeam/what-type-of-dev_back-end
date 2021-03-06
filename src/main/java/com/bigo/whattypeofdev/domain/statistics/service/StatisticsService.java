package com.bigo.whattypeofdev.domain.statistics.service;


import com.bigo.whattypeofdev.domain.statistics.exception.StatisticsParameterException;
import com.bigo.whattypeofdev.domain.statistics.dto.*;
import com.bigo.whattypeofdev.domain.statistics.repository.AnswerRepository;
import com.bigo.whattypeofdev.domain.statistics.repository.StatisticGroupRepository;
import com.bigo.whattypeofdev.domain.statistics.repository.SurveyRecordRepository;
import com.bigo.whattypeofdev.global.entity.Question;
import com.bigo.whattypeofdev.global.entity.StatisticGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class StatisticsService {

    private final SurveyRecordRepository surveyRecordRepository;
    private final StatisticGroupRepository statisticGroupRepository;
    private final AnswerRepository answerRepository;
    public int getSurveyRecordCount(){
        return (int)surveyRecordRepository.count();
    }

    public StatisticsHeaderDto getStatisticsHeader(){
        int userCount = getSurveyRecordCount();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = LocalDateTime.now().format(formatter);
        int careerCount = (int)surveyRecordRepository.countByAboutmeDev(1);

        return StatisticsHeaderDto
                .builder()
                .endDate(date)
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
                .map(statisticGroup -> getContent(statisticGroup))
                .collect(Collectors.toList());
    }

    public StatisticsContentDto getContent(StatisticGroup statisticGroup){
        return StatisticsContentDto.converter(statisticGroup,getTotalDescription(statisticGroup),getResult(statisticGroup));
    }

    public List<String> getTotalDescription(StatisticGroup statisticGroup) {
        List<String> descriptionList = StatisticsGroupTotalDescription.valueOf(statisticGroup.getStatisticName()).toList();
        if (statisticGroup.getStatisticName().equals("?????????")) {
            descriptionList.set(0,String.format(descriptionList.get(0)
                    ,Integer.toString(surveyRecordRepository.countByAboutmeDev(1)),
                    Integer.toString(surveyRecordRepository.countByAboutmeDev(2))));
            List<String> top3 = surveyRecordRepository.findAllTopByColumn("aboutme_dev_type");
            descriptionList.set(1,String.format(descriptionList.get(1),top3.get(0),top3.get(1),top3.get(2)));
            descriptionList.set(2,String.format(descriptionList.get(2),surveyRecordRepository.findTopByColumn("aboutme_salary")));
            int percent = (surveyRecordRepository.countByLifeJob(1)
                                            + surveyRecordRepository.countByLifeJob(2)
                                            + surveyRecordRepository.countByLifeJob(3))*100
                                            / surveyRecordRepository.countAll("life_job");

            descriptionList.set(3,String.format(descriptionList.get(3),Integer.toString(percent)));

        }

        else if(statisticGroup.getStatisticName().equals("????????????")){
            descriptionList.set(0,String.format(descriptionList.get(0),surveyRecordRepository.findTopByColumn("aboutme_work")));
            int iosPercent = surveyRecordRepository.countByAboutmeMobile(1)*100/surveyRecordRepository.countAll("aboutme_mobile");
            descriptionList.set(1,String.format(descriptionList.get(1),Integer.toString(iosPercent),Integer.toString(100-iosPercent)));
            int percent = (surveyRecordRepository.countByLifeGood(0)
                    +surveyRecordRepository.countByLifeGood(1)
                    +surveyRecordRepository.countByLifeGood(2)
                    +surveyRecordRepository.countByLifeGood(3)
                    +surveyRecordRepository.countByLifeGood(4)
            )*100/surveyRecordRepository.countAll("life_good");
            descriptionList.set(2,String.format(descriptionList.get(2),Integer.toString(percent)));

            List<String> top3 = surveyRecordRepository.findAllTopByColumn("dev_drink");
            descriptionList.set(3, String.format(descriptionList.get(3), top3.get(0), top3.get(1), top3.get(2)));
        }
        return descriptionList;
    }

    public List<StatisticsResultDto> getResult(StatisticGroup statisticGroup){
        return statisticGroup.getQuestionList().stream().map(question -> StatisticsResultDto.converter(question,getChartInfo(question))).collect(Collectors.toList());
    }

    public StatisticsResultChartInfoDto getChartInfo(Question question){
        String questionInitial = question.getQuestionInitial();
        StatisticsResultChartInfoDto statisticsResultChartInfoDto;
        if(question.getChartType().equals("doughnut")) {
            statisticsResultChartInfoDto = StatisticsResultChartInfoDto.converter(surveyRecordRepository.findAllTopByColumn(questionInitial), surveyRecordRepository.findAllTopcountByColumn(questionInitial), (int) surveyRecordRepository.count());
        }else{
            statisticsResultChartInfoDto = StatisticsResultChartInfoDto.converter(surveyRecordRepository.findAllByColumn(questionInitial),surveyRecordRepository.findAllCountByColumn(questionInitial),(int) surveyRecordRepository.count());
        }
        return statisticsResultChartInfoDto;
    }

    public StatisticsResultChartInfoDto getStatisticswithFilter(String gender, String age) {
        int answerSeqGender=-1;
        int answerSeqAge=-1;

        try {
            if (!gender.equals("??????")) {
                answerSeqGender = answerRepository.findByAnswer(gender).getAnswerSeq();
            }
            if (!age.equals("??????")) {
                answerSeqAge = answerRepository.findByAnswer(age).getAnswerSeq();
            }
        }catch(NullPointerException n){
            throw new StatisticsParameterException("????????? ??????????????? ????????? ????????? ??? ????????????.");
        }

        return  StatisticsResultChartInfoDto.converter(surveyRecordRepository.findAllByColumnWithFilter("aboutme_dev_type",answerSeqGender,answerSeqAge),surveyRecordRepository.findAllcountByColumnWithFilter("aboutme_dev_type",answerSeqGender,answerSeqAge),1);

    }
}
