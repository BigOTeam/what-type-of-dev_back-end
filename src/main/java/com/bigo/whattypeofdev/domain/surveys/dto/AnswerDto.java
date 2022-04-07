package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.QuestionAnswer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@ApiModel
public class AnswerDto {
    @ApiModelProperty(name = "답변 번호", example = "1")
    private int answerSeq;
    @ApiModelProperty(name = "답변 내용", example = "네")
    private String answer;

    @Builder
    public AnswerDto(int answerSeq, String answer) {
        this.answerSeq = answerSeq;
        this.answer = answer;
    }

    public static AnswerDto fromEntity(QuestionAnswer questionAnswer){
        return AnswerDto.builder()
                .answer(questionAnswer.getAnswer().getAnswer())
                .answerSeq(questionAnswer.getAnswer().getAnswerSeq())
                .build();
    }
}
