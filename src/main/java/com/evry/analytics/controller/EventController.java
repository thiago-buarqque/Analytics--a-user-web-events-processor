package com.evry.analytics.controller;

import com.evry.analytics.DTO.EventDTO;
import com.evry.analytics.model.entity.Event;
import com.evry.analytics.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

@RequestMapping("/event")
@AllArgsConstructor
@RestController
public class EventController extends BaseController {

    @GetMapping("/{visitorId}")
    public List<EventDTO> fetchAllUserEvents(
            @PathVariable String visitorId,
            @RequestParam(required = false) OffsetDateTime dateEnd,
            @RequestParam(required = false) OffsetDateTime dateStart) {

        List<Event> events = eventService.getVisitorEvents(dateEnd, dateStart, visitorId);

        return events.stream().map(
                (event -> objectMapper.convertValue(event, EventDTO.class)
            )).collect(Collectors.toList());
    }

    @PostMapping("/register")
    public EventDTO registerEvent(@Valid @RequestBody EventDTO eventDTO) {
        if (eventDTO.getDateTime() == null) {
            eventDTO.setDateTime(OffsetDateTime.now());
        }

        return objectMapper.convertValue(
                eventService.addEvent(objectMapper.convertValue(eventDTO, Event.class)),
                EventDTO.class);
    }

    private final EventService eventService;
    private final ObjectMapper objectMapper;
}
