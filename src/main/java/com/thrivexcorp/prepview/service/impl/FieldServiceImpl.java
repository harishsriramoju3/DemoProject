package com.thrivexcorp.prepview.service.impl;

import com.thrivexcorp.prepview.database.PostgresService;
import com.thrivexcorp.prepview.entity.FieldConfig;
import com.thrivexcorp.prepview.entity.ObjectConfig;
import com.thrivexcorp.prepview.repository.FieldRepository;
import com.thrivexcorp.prepview.service.FieldService;
import com.thrivexcorp.prepview.service.ObjectService;
import com.thrivexcorp.prepview.utils.DataUtility;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.thrivexcorp.prepview.enums.SourceType.CUSTOM;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private PostgresService postgresService;

    @Autowired
    private ObjectService objectService;

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public FieldConfig createField(FieldConfig fieldConfig) throws SQLException {
        try{
            validateAndCreateField(fieldConfig);
             fieldRepository.save(fieldConfig);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return fieldConfig;
    }


    private void validateAndCreateField(FieldConfig fieldConfig) throws IllegalArgumentException, SQLException {
        if(ObjectUtils.isEmpty(fieldConfig)) {
            throw new IllegalArgumentException("Object cannot be null");
        }
        if(StringUtils.isEmpty(fieldConfig.getDisplayName())){
            throw new IllegalArgumentException("Display name cannot be null");
        }else{
            fieldConfig.setFieldName(DataUtility.generateNameFromDisplayName(fieldConfig.getDisplayName()));
        }
        if(!ObjectUtils.isEmpty(fieldConfig.getObjectId())) {
            Optional<ObjectConfig> objectConfig = objectService.getObjectById(UUID.fromString(fieldConfig.getObjectId()));
            if(objectConfig.isPresent()){
                postgresService.addFieldToTable(objectConfig.get().getObjectName(),fieldConfig.getFieldName(), fieldConfig.getFieldType());
            }else{
                throw new IllegalArgumentException("Invalid Object");
            }
        }else{
            throw new IllegalArgumentException("Object cannot be null");
        }
        fieldConfig.setSourceType(CUSTOM.name());
    }

    @Override
    public FieldConfig updateField(UUID id, FieldConfig fieldConfig) {
        if (fieldRepository.existsById(id)) {
            return fieldRepository.save(fieldConfig);
        } else {
            throw new EntityNotFoundException("Field not found with ID: " + id);
        }
    }


    @Override
    public void deleteField(UUID id) {
        if (fieldRepository.existsById(id)) {
            fieldRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Field not found with ID: " + id);
        }
    }

    @Override
    public Optional<FieldConfig> getFieldById(UUID id) {
        return fieldRepository.findById(id);
    }

    @Override
    public List<FieldConfig> getAllFields() {
        return fieldRepository.findAll();
    }
}
