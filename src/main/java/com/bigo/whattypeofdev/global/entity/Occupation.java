package com.bigo.whattypeofdev.global.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Occupation {

    Websites("Websites","웹 개발자"),
    Utilities("Utilities"," 유틸리티 개발자"),
    Database("Database/Data Storage","DB 엔지니어"),

    SystemSoftware("SystemSoftware","OS 개발자"),
    ITInfrastructure("ITInfrastructure","인프라 엔지니어"),
    Finance("Finance","금융권 개발자"),
    DataScience("Business Intelligence/ Data Science / Machine Learning","데이터 사이언티스트"),
    Game("Games","게임 개발자"),
    Entertainment("Entertainment","엔터테인먼트 서비스 개발자"),
    ProgrammingTools("Programming Tools","툴 개발자(Tool developer)");

    private final String occupation;
    private final String jobName;
}
