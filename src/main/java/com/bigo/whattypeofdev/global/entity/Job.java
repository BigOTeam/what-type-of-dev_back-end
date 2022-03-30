package com.bigo.whattypeofdev.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="tb_job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private Long jobId;

    @Enumerated(EnumType.STRING)
    @Column(name="job_name",length=200)
    private Occupation jobName;

    @Column(name="job_description",length = 1000)
    private String jobDescription;

    @Column(name="job_img",length = 1000)
    private String jobImg;

}
