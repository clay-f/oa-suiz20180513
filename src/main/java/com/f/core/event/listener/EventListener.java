package com.f.core.event.listener;

import com.f.core.enums.EventType;

public interface EventListener {
    void notify(EventType eventType);
}
