package com.evry.analytics.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
public class EventDTO {

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
