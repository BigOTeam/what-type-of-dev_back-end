package com.bigo.whattypeofdev.domain.statistics.dto;


import com.bigo.whattypeofdev.global.entity.Question;
import com.bigo.whattypeofdev.global.entity.StatisticGroup;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsQuestionInfoDto {

    private Long id;
    private String question;

    private StatisticsQuestionInfoDto(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public static StatisticsQuestionInfoDto fromEntity(Question question){
        return new StatisticsQuestionInfoDto(question.getQuestionId(),question.getQuestion());
    }
}
