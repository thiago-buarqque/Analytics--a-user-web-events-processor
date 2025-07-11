package com.evry.analytics.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.validation.Constraint;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
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

    private OffsetDateTime createDate;

    @GeneratedValue
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID uuid;
    /* TODO: perguntar no StackOverflow sobre a inicalização do esquema do
       banco de dados com Spring. Para que usar as anotações do hibernate se
       terei que criar um SQL e definir as relações?
    */
    @Nullable
    private Long userId;
}
