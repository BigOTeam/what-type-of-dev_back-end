package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_job")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Long answerId;

    @Column(name="answer",length = 500)
    private String answer;

    @Column(name="answer_seq")
    private int answerSeq;

    @ManyToOne()
    @JoinColumn(name="question_id")
    private Question question;


}
