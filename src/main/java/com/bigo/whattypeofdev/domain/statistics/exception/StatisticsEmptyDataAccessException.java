package com.bigo.whattypeofdev.domain.statistics.exception;

import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import com.bigo.whattypeofdev.global.exception.CustomException;

public class StatisticsEmptyDataAccessException extends CustomException {

    public StatisticsEmptyDataAccessException() {
        super(ErrorStatusEnum.EMPTY_RESPONSE,"데이터가 비어있다구우후훗");
    }
}
