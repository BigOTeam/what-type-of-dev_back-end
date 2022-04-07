package com.bigo.whattypeofdev.domain.statistics.exception;

import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import com.bigo.whattypeofdev.global.exception.CustomException;

public class StatisticsException extends CustomException {

    public StatisticsException(ErrorStatusEnum errorStatusEnum, String message) {
        super(errorStatusEnum, message);
    }

}
