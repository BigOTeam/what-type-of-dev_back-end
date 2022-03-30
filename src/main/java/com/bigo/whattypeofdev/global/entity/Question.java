package com.bigo.whattypeofdev.global.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name="tb_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
    private Long questionId;

    @Column(name="question",length = 500)
    @NonNull
    private String question;

    @Column(name="question_initial",length=100)
    @NonNull
    private String questionInitial;

    @Column(name="chart_type",length=100)
    private String chartType;

    @ManyToOne
    @JoinColumn(name="page_id")
    private Page page;

    @ManyToOne
    @JoinColumn(name="statistic_id")
    private StatisticGroup statisticGroup;

    @OneToMany(mappedBy = "question")
    private List<QuestionAnswer> questionAnswerList;

    @Builder
    public Question(String question,String questionInitial,String chartType){
        if(question==null||questionInitial==null){
            throw new IllegalArgumentException("question 필수 파라미터 누락");
        }
        this.question = question;
        this.questionInitial = questionInitial;
        this.chartType = chartType;
    }

}
