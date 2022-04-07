package com.bigo.whattypeofdev.domain.surveys.exception;

import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import com.bigo.whattypeofdev.global.exception.CustomException;

public class SurveyParameterException extends CustomException {

    public SurveyParameterException(String msg) {
        super(ErrorStatusEnum.PARAMETER_NOT_VALID,msg);
    }
    public SurveyParameterException(){
        super(ErrorStatusEnum.PARAMETER_NOT_VALID,"잘못된 파라미터 요청입니다.");
    }
}
