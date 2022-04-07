package com.bigo.whattypeofdev.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private ErrorStatusEnum code;
    private String message;

    private ErrorResponse(ErrorStatusEnum code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse of(ErrorStatusEnum code, String message) {
        return new ErrorResponse(code, message);
    }

}
