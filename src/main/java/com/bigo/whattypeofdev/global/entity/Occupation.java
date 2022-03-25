package com.bigo.whattypeofdev.global.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Occupation {
    Websites("WebDeveloper","웹개발자"),
    Database("DBDeveloper","DB개발자"),
    ItInfrastructure("",""),
    DataScientist("","데이터사이언티스트"),
    Finance("","금융개발자?"),
    Game("","게임개발자"),
    Entertainment("",""),
    SystemSoftware("","");

    private final String occupation;
    private final String jobName;
}
