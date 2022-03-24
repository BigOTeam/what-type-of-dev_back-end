package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;

@Entity
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
    private String jobImageUrl;
}
