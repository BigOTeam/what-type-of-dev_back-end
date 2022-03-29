package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_question_answer")
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_answer_id")
    private Long questionAnswerId;

    @ManyToOne
    @Column(name="question_id")
    private Question question;

    @ManyToOne
    @Column(name="answer_id")
    private Answer answer;
}
