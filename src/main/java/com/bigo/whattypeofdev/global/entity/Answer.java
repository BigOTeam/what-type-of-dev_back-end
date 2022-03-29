package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "questionanswer")
    private List<QuestionAnswer> questionAnswerList;

}
