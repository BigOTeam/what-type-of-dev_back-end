package com.bigo.whattypeofdev.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private ErrorStatusEnum status;
    private String message;

    public static ErrorResponse of(ErrorStatusEnum status, String message) {
        return new ErrorResponse(status, message);
    }

}
