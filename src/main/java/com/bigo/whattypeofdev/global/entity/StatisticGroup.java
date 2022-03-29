package com.bigo.whattypeofdev.global.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name="tb_statistic_group")
public class StatisticGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statistic_id")
    private Long statisticId;

    @Column(name="statistic_name",length = 500)
    private String statisticName;

    @Column(name="statistic_img",length = 1000)
    private String statisticImg;

    @OneToMany(mappedBy = "question")
    private List<Question> questionList;
}
