package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.QuestionAnswer;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AnswerDto {
    private int answerSeq;
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
