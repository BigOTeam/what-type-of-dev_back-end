package com.bigo.whattypeofdev.global.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name="tb_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
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

    @OneToMany(mappedBy = "questionanswer")
    private List<QuestionAnswer> questionAnswerList;

}
