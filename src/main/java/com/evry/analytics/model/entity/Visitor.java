package com.evry.analytics.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@Table
public class Visitor {

    private LocalDateTime createDate;

    @Id private String id;

    private String userId;
}
