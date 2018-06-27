package com.f.core.event.listener;

import com.f.core.enums.EventType;
import com.f.core.event.EventContent;
import com.f.core.event.handler.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractEventListener implements EventListener {
    private final EventType eventType;
    @Autowired
    private List<EventHandler> eventHandlers;

    public AbstractEventListener(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public void notify(EventContent eventContent) {
        if (eventType == eventContent.getEventType()) {
            doSyncExecute(eventContent);
        }
    }

    protected void doSyncExecute(final EventContent eventContent) {
        for (EventHandler eventHandler
                : eventHandlers) {
            try {
                eventHandler.handle(eventContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
