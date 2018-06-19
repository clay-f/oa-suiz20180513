package com.f.enums;

public enum State {
    FALSE(0, "false"), TRUE(1, "true");

    private Integer code;
    private String message;

    State(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
