package com.bigo.whattypeofdev.domain.surveys.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SurveyInfoDto {
    private String question;
    private String questionInitial;
    private List<AnswerDto> answers;

    @Builder
    public SurveyInfoDto(String question, String questionInitial, List<AnswerDto> answers) {
        this.question = question;
        this.questionInitial = questionInitial;
        this.answers = answers;
    }


}
