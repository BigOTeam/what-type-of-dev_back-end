package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;

@Entity
public class StatisticGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statistic_id")
    private Long statisticId;

    @Column(name="statistic_name",length = 500)
    private String statisticName;

    @Column(name="statistic_img",length = 1000)
    private String statisticImage;
}
