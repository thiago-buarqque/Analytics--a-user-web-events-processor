package com.evry.analytics.service.impl;

import com.evry.analytics.model.entity.Event;
import com.evry.analytics.repository.EventRepository;

import com.evry.analytics.service.EventService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getVisitorEvents(
            OffsetDateTime dateEnd, OffsetDateTime dateStart, String visitorId) {

        if (dateEnd == null) {
            dateEnd = OffsetDateTime.now();
        }

        if (dateStart == null) {
            dateStart = dateEnd.minusHours(24);
        }

        return eventRepository.findEventsByDateTimeBetweenAndVisitorId(dateStart, dateEnd, visitorId);
    }

    private final EventRepository eventRepository;
}
