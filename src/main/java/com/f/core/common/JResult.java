package com.f.core.common;

public class JResult {
    private Object result;
    private String message;
    private int code;

    public JResult() {
    }

    public JResult(Object result, String message, int code) {
        this.result = result;
        this.message = message;
        this.code = code;
    }

    public JResult(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static JResult success(Object obj) {
        return new JResult(obj, "ok", 200);
    }

    public static JResult unauthorized() {
        return new JResult("login false, please confirm your name or passord", 404);
    }
}
