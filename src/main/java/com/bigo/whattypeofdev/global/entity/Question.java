package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}
