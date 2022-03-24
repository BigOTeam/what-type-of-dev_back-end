package com.bigo.whattypeofdev.global.common;

import lombok.Data;

@Data
public class Response {
    private StatusEnum status;
    private String message;
    private Object data;

    public Response() {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
