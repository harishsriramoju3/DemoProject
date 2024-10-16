package com.thrivexcorp.prepview.repository;


import com.thrivexcorp.prepview.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TemplateRepository extends JpaRepository<Template, UUID> {
}

