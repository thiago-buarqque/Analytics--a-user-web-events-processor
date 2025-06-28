package com.evry.analytics.DTO;

import com.evry.analytics.model.entity.Event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
public class EventDTO {

    public EventDTO() {}

    public EventDTO(Event event) {
        browserName = event.getBrowserName();
        canonicalUrl = event.getCanonicalUrl();
        createDate = event.getCreateDate();
        dateTime = event.getDateTime();
        deviceType = event.getDeviceType();
        id = event.getUuid().toString();
        metadata = event.getMetadata();
        pageTitle = event.getPageTitle();
        properties = event.getProperties();
        referrer = event.getReferrer();
        sessionId = event.getSessionId();
        timezoneOffset = event.getTimezoneOffset();
        type = event.getType();
        visitorId = event.getVisitorId();
    }

    private String browserName;

    @NotNull private String canonicalUrl;

    private LocalDateTime createDate;

    private LocalDateTime dateTime;

    private String deviceType;

    private String id;

    @NotEmpty(message = "Metadata must be provided.")
    private String metadata;

    private String pageTitle;

    private String properties;

    private String referrer;

    @NotNull private String sessionId;

    @NotNull private String timezoneOffset;

    @NotEmpty(message = "Event type must be provided.")
    private String type;

    @NotNull private String visitorId;
}
