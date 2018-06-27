package com.f.core.enums;

public enum EventType {
    CHANGE_VOUCHER("change voucher state", 1);
    private String name;
    private Integer code;

    EventType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}
