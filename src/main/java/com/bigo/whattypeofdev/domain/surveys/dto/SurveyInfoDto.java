package com.bigo.whattypeofdev.domain.surveys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@ApiModel
public class SurveyInfoDto {
    @ApiModelProperty(name="질문", example = "당신은 개발자인가요?")
    private String question;
    @ApiModelProperty(name="질문 약어", example = "aboutme_dev")
    private String questionInitial;
    @ApiModelProperty(name="답변 목록")
    private List<AnswerDto> answers;

    @Builder
    public SurveyInfoDto(String question, String questionInitial, List<AnswerDto> answers) {
        this.question = question;
        this.questionInitial = questionInitial;
        this.answers = answers;
    }


}
