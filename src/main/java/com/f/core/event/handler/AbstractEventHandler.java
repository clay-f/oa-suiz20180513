package com.f.core.event.handler;

import com.f.core.enums.EventType;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public abstract class AbstractEventHandler implements EventHandler {
    private final Set<EventType> eventTypes;


    public AbstractEventHandler(EventType eventTypes) {
        this.eventTypes = ImmutableSet.of(eventTypes);
    }

    public AbstractEventHandler(EventType eventType1, EventType eventType2, EventType eventType3) {
        this.eventTypes = ImmutableSet.of(eventType1, eventType2, eventType3);
    }

    public AbstractEventHandler(EventType eventType1, EventType eventType2) {
        this.eventTypes = ImmutableSet.of(eventType1, eventType2);
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public boolean isSync() {
        return false;
    }

    @Override
    public Set<EventType> getEventType() {
        return null;
    }
}
