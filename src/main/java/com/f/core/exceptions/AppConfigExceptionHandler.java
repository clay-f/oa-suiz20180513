package com.f.core.exceptions;

import com.f.core.common.ResponseJsonResult;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class AppConfigExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseJsonResult notFoundHandler() {
        return ResponseJsonResult.customResponse(HttpStatus.NOT_FOUND, "error not found");
    }

    @ExceptionHandler(SQLException.class)
    public ResponseJsonResult sqlExceptionHandler() {
        return ResponseJsonResult.customResponse(HttpStatus.INTERNAL_SERVER_ERROR, "sql error");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseJsonResult duplicateKeyHandler() {
        return ResponseJsonResult.customResponse(HttpStatus.INTERNAL_SERVER_ERROR, "duplicate key error");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseJsonResult nullPointerHanlder() {
        return ResponseJsonResult.customResponse(HttpStatus.INTERNAL_SERVER_ERROR, "NullPointerException error");
    }
}
