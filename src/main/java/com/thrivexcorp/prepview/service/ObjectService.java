package com.thrivexcorp.prepview.service;

import com.thrivexcorp.prepview.entity.FieldConfig;
import com.thrivexcorp.prepview.entity.ObjectConfig;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ObjectService {
    ObjectConfig createObject(ObjectConfig object) throws SQLException;
    ObjectConfig updateObject(UUID id, ObjectConfig object );
    void deleteObject(UUID id);
    Optional<ObjectConfig> getObjectById(UUID id);
    List<ObjectConfig> getAllObjects();
    List<FieldConfig> getFieldsByObjectId(UUID objectId);
}

