package com.thrivexcorp.prepview.service;

import com.thrivexcorp.prepview.entity.FieldConfig;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FieldService {
    FieldConfig createField(FieldConfig fieldConfig) throws SQLException;
    FieldConfig updateField(UUID id, FieldConfig fieldConfig);
    void deleteField(UUID id);
    Optional<FieldConfig> getFieldById(UUID id);
    List<FieldConfig> getAllFields();

    interface TemplateService {
    }
}

