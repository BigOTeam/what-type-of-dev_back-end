package com.bigo.whattypeofdev.domain.surveys.dto;

import com.bigo.whattypeofdev.global.entity.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@ApiModel
public class SurveyResponseDto {
    @ApiModelProperty(name="페이지 번호", example = "1")
    private int pageNo;
    @ApiModelProperty(name="설문그룹 이름", example = "자기소개")
    private String pageName;
    @ApiModelProperty(name="설문그룹 설명", example = "당신에 대해서 알려주세요!")
    private String pageDescription;
    @ApiModelProperty(name="그룹 이미지", example = "https://~")
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
