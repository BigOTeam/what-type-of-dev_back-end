package com.bigo.whattypeofdev.global.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Table(name="tb_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Long answerId;

    @Column(name="answer_seq")
    private int answerSeq;

    @Column(name="answer",length=500)
    private String answer;

    @OneToMany(mappedBy = "answer")
    private List<QuestionAnswer> questionAnswerList;

    @Builder
    public Answer(int answerSeq,String answer) {
        this.answerSeq = answerSeq;
        this.answer = answer;
    }
}
