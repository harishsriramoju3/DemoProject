package com.thrivexcorp.prepview.repository;

import com.thrivexcorp.prepview.entity.FieldConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FieldRepository extends JpaRepository<FieldConfig, UUID> {

    @Query("SELECT f FROM FieldConfig f WHERE f.objectConfig.id = :objectId")
    List<FieldConfig> findByObjectId(UUID objectId);
}
