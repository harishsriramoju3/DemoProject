package com.thrivexcorp.prepview.repository;

import com.thrivexcorp.prepview.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SectionRepository extends JpaRepository<Section, UUID> {
    List<Section> findByTemplateId(UUID templateId);
}
