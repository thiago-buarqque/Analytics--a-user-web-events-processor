package com.evry.analytics.model.entity;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table
public class Event {

    private String browserName;

    @NotNull private String canonicalUrl;

    private LocalDateTime createDate;

    private LocalDateTime dateTime;

    private String deviceType;

    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                @Parameter(
                        name = "uuid_gen_strategy_class",
                        value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
            })
    @Id
    private UUID id;

    @NotNull private String metadata;

    private String pageTitle;

    private String properties;

    private String referrer;

    @NotNull private String sessionId;

    @NotNull private String timezoneOffset;

    @NotNull private String type;

    @NotNull private String visitorId;
}
