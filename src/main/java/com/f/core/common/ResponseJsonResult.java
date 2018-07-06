package com.f.core.common;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ResponseJsonResult {
    private Object result;
    private HttpStatus httpStatus;

    public ResponseJsonResult() {
    }

    public ResponseJsonResult( HttpStatus httpStatus, Object result) {
        this.result = result;
        this.httpStatus = httpStatus;
    }

    @JsonView
    public String getHttpStatus() throws JsonProcessingException {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", httpStatus.value());
        map.put("message", httpStatus.getReasonPhrase());
        return new ObjectMapper().writeValueAsString(map);
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @JsonView
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static ResponseJsonResult customResponse(HttpStatus status, Object object) {
        return new ResponseJsonResult(status, object);
    }

    public static ResponseJsonResult successResponse(Object object) {
        return new ResponseJsonResult(HttpStatus.OK, object);
    }
}
