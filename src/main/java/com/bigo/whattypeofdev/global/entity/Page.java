package com.bigo.whattypeofdev.global.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Table(name="tb_page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="page_id")
    private Long pageId;

    @Column(name="page_name",length=200)
    private String pageName;

    @Column(name="page_description",length = 1000)
    private String pageDescription;

    @Column(name="page_img",length = 1000)
    private String pageImg;

    @Column(name="page_no")
    private int pageNo;

    @OneToMany(mappedBy="page")
    private List<Question> questionList;

    @Builder
    public Page(String pageName,String pageDescription,String pageImg,int pageNo){
        if(pageName==null||pageNo==0){
            throw new IllegalArgumentException("설문 그룹 필수 파라미터 부족");
        }else{
            this.pageName=pageName;
            this.pageDescription=pageDescription;
            this.pageImg = pageImg;
        }
    }

}
