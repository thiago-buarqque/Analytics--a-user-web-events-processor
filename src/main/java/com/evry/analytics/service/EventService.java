package com.evry.analytics.service;

import com.evry.analytics.model.entity.Event;

import java.time.OffsetDateTime;
import java.util.List;

public interface EventService {
    Event addEvent(Event event);

    List<Event> getVisitorEvents(
            OffsetDateTime dateEnd, OffsetDateTime dateStart, String visitorId);

}
