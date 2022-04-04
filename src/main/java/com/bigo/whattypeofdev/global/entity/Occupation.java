package com.bigo.whattypeofdev.global.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Occupation {
    Websites("Websites","웹개발자"),
    Utilities("Utilities",""),
    Database("Database/Data Storage","DB개발자"),
    SystemSoftware("System Software",""),
    ItInfrastructure("IT Infrastructure",""),
    Finance("Finance","금융개발자?"),
    DataScience("Business Intelligence/ Data Science / Machine Learning","데이터사이언티스트"),
    Game("Games","게임개발자"),
    Entertainment("Entertainment",""),
    ProgrammingTools("Programming Tools","");

    private final String occupation;
    private final String jobName;
}
