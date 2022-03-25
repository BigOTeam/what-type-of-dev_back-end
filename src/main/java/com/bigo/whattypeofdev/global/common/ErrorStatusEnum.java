package com.bigo.whattypeofdev.global.common;

import lombok.Getter;

@Getter
public enum ErrorStatusEnum {

    BAD_REQUEST(400,"BAD REQUEST"),
    INTERNAL_SERVER_ERROR(500,"INTERNAL SERVER ERROR");

    int code;
    String message;

    ErrorStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
