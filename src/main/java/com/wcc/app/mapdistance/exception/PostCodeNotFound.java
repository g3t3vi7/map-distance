package com.wcc.app.mapdistance.exception;

import lombok.Getter;

@Getter
public class PostCodeNotFound extends RuntimeException {
    private String errorMsg;

    public PostCodeNotFound(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
