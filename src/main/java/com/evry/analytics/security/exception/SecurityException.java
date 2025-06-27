package com.evry.analytics.security.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class SecurityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private final HttpStatus httpStatus;

    public SecurityException(String message, HttpStatus httpStatus) {
        super(message);

        this.httpStatus = httpStatus;
    }

}
