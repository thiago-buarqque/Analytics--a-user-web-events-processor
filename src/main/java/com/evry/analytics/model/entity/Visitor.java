package com.evry.analytics.model.entity;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.lang.Nullable;

@Entity
@Getter
@Setter
@Table
public class Visitor {

    private LocalDateTime createDate;

    @GeneratedValue
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID uuid;

    @Nullable
    private String userId;
}
