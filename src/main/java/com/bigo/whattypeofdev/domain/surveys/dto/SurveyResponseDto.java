package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.Page;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SurveyResponseDto {
    private int pageNo;
    private String pageName;
    private String pageDescription;
    private String pageImageUrl;
    private List<SurveyInfoDto> surveys;

    @Builder
    public SurveyResponseDto(int pageNo, String pageName, String pageDescription, String pageImageUrl, List<SurveyInfoDto> surveys) {
        this.pageNo = pageNo;
        this.pageName = pageName;
        this.pageDescription = pageDescription;
        this.pageImageUrl = pageImageUrl;
        this.surveys = surveys;

    }

    public static SurveyResponseDto fromEntitywithSurveyInfoDto (Page page, List<SurveyInfoDto> surveys){
        SurveyResponseDto surveyResponseDto = SurveyResponseDto.builder()
                .pageNo(page.getPageNo())
                .pageName(page.getPageName())
                .pageDescription(page.getPageDescription())
                .pageImageUrl(page.getPageImg())
                .surveys(surveys)
                .build();
        return surveyResponseDto;
    }

}
