package com.bigo.whattypeofdev.global.exception;

import com.bigo.whattypeofdev.global.common.ErrorStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorStatusEnum errorStatusEnum;

    public CustomException(ErrorStatusEnum errorStatusEnum, String message){
        super(message);
        this.errorStatusEnum = errorStatusEnum;
    }
}

