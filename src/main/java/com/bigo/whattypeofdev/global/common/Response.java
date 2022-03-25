package com.bigo.whattypeofdev.global.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {
    private StatusEnum status;
    private String message;
    private Object data;

}
