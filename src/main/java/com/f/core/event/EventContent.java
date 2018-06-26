package com.f.core.event;

import com.f.core.enums.EventType;

import java.util.Map;

public class EventContent {
    private String targetId;
    private EventType eventType;
    private Map<String, Object> data;

    public EventContent() {
    }

    public EventContent(String targetId, EventType eventType) {
        this.targetId = targetId;
        this.eventType = eventType;
    }

    public EventContent(String targetId, EventType eventType, Map<String, Object> data) {
        this.targetId = targetId;
        this.eventType = eventType;
        this.data = data;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public <T> T getValue(String key) {
        return (T) data.get(key);
    }
}
