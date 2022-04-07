package com.bigo.whattypeofdev.global.common;

import lombok.Getter;

@Getter
public enum ErrorStatusEnum {

    BAD_REQUEST("BAD_REQUEST","BAD REQUEST",400),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR","INTERNAL SERVER ERROR",500),
    PARAMETER_NOT_VALID("PARAMETER_NOT_VALID","PARAMETER_NOT_VALID",416),
    EMPTY_RESPONSE("EMPTY_RESPONSE","EMPTY RESPONSE",418);
    String code;
    String message;
    int status;

    ErrorStatusEnum(String code, String message,int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
