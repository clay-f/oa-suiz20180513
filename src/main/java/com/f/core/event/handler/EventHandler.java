package com.f.core.event.handler;

import com.f.core.enums.EventType;
import com.f.core.event.EventContent;

import java.util.Set;

public interface EventHandler {
    int order();

    boolean isSync();

    Set<EventType> getEventType();

    void handle(EventContent eventContent);
}
