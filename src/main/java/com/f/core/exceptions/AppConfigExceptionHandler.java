package com.f.core.exceptions;

import com.f.core.common.ResponseJsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppConfigExceptionHandler {
    @ExceptionHandler
    public ResponseJsonResult notFound() {
        return ResponseJsonResult.customResponse(HttpStatus.NOT_FOUND, "error not found");
    }
}
