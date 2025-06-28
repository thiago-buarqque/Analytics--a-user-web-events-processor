package com.evry.analytics.repository;

import com.evry.analytics.model.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends CustomEventRepository, JpaRepository<Event, UUID> {

    List<Event> findEventsByDateTimeBetweenAndVisitorId(
            OffsetDateTime date1, OffsetDateTime date2, String visitorId);
}
