package com.evry.analytics.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID uuid;

    @NotNull private String metadata;

    private String pageTitle;

    private String properties;

    private String referrer;

    @NotNull private String sessionId;

    @NotNull private String timezoneOffset;

    @NotNull private String type;

    @NotNull private String visitorId;
}
