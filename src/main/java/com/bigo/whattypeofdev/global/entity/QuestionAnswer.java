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
    @JoinColumn(name="question_id")
    private Question question;

    @OneToMany(mappedBy = "Answer")
    private List<Answer> answerList;


}
