package com.bigo.whattypeofdev.global.common;

import lombok.Getter;

@Getter
public enum StatusEnum {
    OK(200,"OK");

    int code;
    String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
