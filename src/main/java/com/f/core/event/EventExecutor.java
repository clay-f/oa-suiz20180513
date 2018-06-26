package com.f.core.event;

import com.f.core.event.listener.EventListener;
import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EventExecutor implements ApplicationContextAware {

    private static List<EventListener> eventListeners;

    public static void fireEvent(final EventContent eventContent) {
        if (CollectionUtils.isNotEmpty(eventListeners)) {
            for (EventListener messageListener : eventListeners) {
                try {
                    messageListener.notify(eventContent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, EventListener> beans = applicationContext.getBeansOfType(EventListener.class);
        eventListeners = ImmutableList.<EventListener> copyOf(beans.values());
    }

}