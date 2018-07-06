package com.f.core.common;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ResponseJsonResult {
    private Object result;
    private HttpStatus status;

    public ResponseJsonResult() {
    }

    public ResponseJsonResult(HttpStatus status, Object result) {
        this.result = result;
        this.status = status;
    }

    @JsonView
    public Object getStatus() throws JsonProcessingException {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", status.value());
        map.put("message", status.getReasonPhrase());
        return map;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
