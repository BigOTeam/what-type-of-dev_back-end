package com.bigo.whattypeofdev.domain.surveys.exception;

import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import com.bigo.whattypeofdev.global.exception.CustomException;

public class SurveyNotFoundException extends CustomException {

    public SurveyNotFoundException(String message) {
        super(ErrorStatusEnum.BAD_REQUEST, message);
    }
}
