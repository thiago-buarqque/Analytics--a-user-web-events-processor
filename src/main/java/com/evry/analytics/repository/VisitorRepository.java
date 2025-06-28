package com.evry.analytics.repository;

import com.evry.analytics.model.entity.Visitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.UUID;

@Repository
@Transactional
public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
    public void deleteByUserId(Long userId);
}
