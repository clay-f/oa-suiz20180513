package com.f.core.event.listener;

import com.f.core.event.EventContent;

public interface EventListener {
    void notify(EventContent eventContent);
}
