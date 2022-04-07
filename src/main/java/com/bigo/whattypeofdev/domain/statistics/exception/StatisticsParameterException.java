package com.bigo.whattypeofdev.domain.statistics.exception;

import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import com.bigo.whattypeofdev.global.exception.CustomException;

public class StatisticsParameterException extends CustomException {

    public StatisticsParameterException(String msg) {
        super(ErrorStatusEnum.PARAMETER_NOT_VALID,msg);
    }
}
