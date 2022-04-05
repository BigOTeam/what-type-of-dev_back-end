package com.bigo.whattypeofdev.domain.statistics.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum StatisticsGroupTotalDescription {

    프로필("저희 설문조사는 %d명의 개발자와 %d명의 예비 개발자가 참여했습니다.",
            "참여한 현 개발자의 Top3는 %s,%s,%s 순서였습니다.",
            "희망연봉 1순위는 %s이었습니다.",
            "현재 직업에 만족하는 비율은 %d%였습니다."),
    생활모습("선호하는 근무형태 1순위는 %s였습니다.","사용하는 모바일 운영체제는 iOS가 %d%, Android가 %d%였습니다.",
            "현재 삶에 만족하는 비율은 %d%였습니다.",
            "일할 때 즐겨 마시는 음료 Top 3는 %s, %s, %s 순서였습니다.");

    private final String description;
    private final String summaryInfo1;
    private final String summaryInfo2;
    private final String summaryInfo3;

    public List<String> toList(){
        return new ArrayList<String>(Arrays.asList(description,summaryInfo1,summaryInfo2,summaryInfo3));
    }
}
