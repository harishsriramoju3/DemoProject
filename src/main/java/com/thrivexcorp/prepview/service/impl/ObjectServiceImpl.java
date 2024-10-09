package com.thrivexcorp.prepview.service.impl;

import com.thrivexcorp.prepview.database.PostgresService;
import com.thrivexcorp.prepview.entity.FieldConfig;
import com.thrivexcorp.prepview.entity.ObjectConfig;
import com.thrivexcorp.prepview.repository.FieldRepository;
import com.thrivexcorp.prepview.repository.ObjectRepository;
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
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private PostgresService postgresService;

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public ObjectConfig createObject(ObjectConfig object) throws SQLException {
        validateObject(object);
        postgresService.createTable(object.getObjectName());
        return objectRepository.save(object);
    }

    private void validateObject(ObjectConfig objectConfig) throws IllegalArgumentException {
        if(ObjectUtils.isEmpty(objectConfig)) {
            throw new IllegalArgumentException("Object cannot be null");
        }
        if(StringUtils.isEmpty(objectConfig.getDisplayName())){
            throw new IllegalArgumentException("Display name cannot be null");
        }else{
            objectConfig.setObjectName(DataUtility.generateNameFromDisplayName(objectConfig.getDisplayName()));
        }
        objectConfig.setSourceType(CUSTOM.name());
    }

    @Override
    public ObjectConfig updateObject(UUID id, ObjectConfig object) {
        if (objectRepository.existsById(id)) {
            return objectRepository.save(object);
        } else {
            throw new EntityNotFoundException("Object not found with ID: " + id);
        }
    }


    @Override
    public void deleteObject(UUID id) {
        if (objectRepository.existsById(id)) {
            objectRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Object not found with ID: " + id);
        }
    }

    @Override
    public Optional<ObjectConfig> getObjectById(UUID id) {
        return objectRepository.findById(id);
    }

    @Override
    public List<ObjectConfig> getAllObjects() {
        return objectRepository.findAll();
    }

    @Override
    public List<FieldConfig> getFieldsByObjectId(UUID objectId) {
        return fieldRepository.findByObjectId(objectId);
    }
}

