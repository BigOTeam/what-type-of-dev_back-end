package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name="question",length = 500)
    private String question;

    @Column(name="question_initial",length=100)
    private String questionInitial;

    @Column(name="chart_type",length=100)
    private String chartType;

    @ManyToOne
    @JoinColumn(name="page_id")
    private Page page;

    @ManyToOne
    @JoinColumn(name="statistic_id")
    private StatisticGroup statisticGroup;

    @OneToMany(mappedBy = "answer")
    private List<Answer> answerList;

}
