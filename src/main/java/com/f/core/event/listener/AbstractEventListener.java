package com.f.core.event.listener;

import com.f.core.enums.EventType;
import com.f.core.event.EventContent;
import com.f.core.event.handler.EventHandler;
import com.f.helper.CreateExecutorThread;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class AbstractEventListener implements EventListener, InitializingBean {
    private final EventType eventType;
    private final static ExecutorService executorService = CreateExecutorThread.getCachedThreadPool();
    @Autowired
    private List<EventHandler> syncHandlers;

    @Autowired
    private List<EventHandler> asyncHandlers;

    public AbstractEventListener(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public void notify(EventContent eventContent) {
        if (eventType == eventContent.getEventType()) {
            doSyncExecute(eventContent);
            doAsyncExecute(eventContent);
        }
    }

    private void doSyncExecute(final EventContent eventContent) {
        assert syncHandlers.size() > 0;
        for (EventHandler eventHandler
                : syncHandlers) {
            try {
                eventHandler.handle(eventContent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doAsyncExecute(final EventContent eventContent) {
        assert asyncHandlers.size() > 0;
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (EventHandler eventHandler : asyncHandlers) {
                    try {
                        eventHandler.handle(eventContent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        doInitAsync();
        doInitAsync();
    }

    private void doInitSync() {
        List<EventHandler> eventHandlers = Lists.newArrayList();
        for (EventHandler eventHandler
                : syncHandlers) {
            if (eventHandler.getEventType().contains(eventType) && eventHandler.isSync()) {
                eventHandlers.add(eventHandler);
            }
        }
        syncHandlers = ImmutableList.<EventHandler>copyOf(eventHandlers);
    }

    private void doInitAsync() {
        List<EventHandler> eventHandlers = Lists.newArrayList();
        for (EventHandler eventHandler
                : syncHandlers) {
            if (eventHandler.getEventType().contains(eventType) && !eventHandler.isSync()) {
                eventHandlers.add(eventHandler);
            }
        }
        asyncHandlers = ImmutableList.<EventHandler>copyOf(eventHandlers);
    }
}
