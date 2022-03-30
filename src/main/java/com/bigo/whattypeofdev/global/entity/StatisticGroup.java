package com.bigo.whattypeofdev.global.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "statisticGroup")
    private List<Question> questionList;

    @Builder
    public StatisticGroup(String statisticName, String statisticImg) {
        if(statisticName==null){
            throw new IllegalArgumentException("statisticGroup 필수 파라미터 누락");
        }
        this.statisticName = statisticName;
        this.statisticImg = statisticImg;
    }
}
