package com.thrivexcorp.prepview.repository;

import com.thrivexcorp.prepview.entity.ObjectConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectConfig, UUID> {
}
