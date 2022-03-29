package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id",length = 500)
    private String answerId;

    @Column(name="answer_seq")
    private int answerSeq;

    @Column(name="answer",length=500)
    private String answer;

    @ManyToOne
    @JoinColumn(name="question_answer_id")
    private QuestionAnswer questionAnswer;


}
