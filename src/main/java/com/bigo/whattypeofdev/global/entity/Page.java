package com.bigo.whattypeofdev.global.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pageId;

    @Column(name="page_name",length=200)
    private String pageName;

    @Column(name="page_description",length = 1000)
    private String pageDescription;

    @Column(name="page_img",length = 1000)
    private String pageImg;

    @Column(name="page_no",length = 1000)
    private String pageNo;

    @OneToMany(mappedBy="question")
    private List<Question> questionList;
}