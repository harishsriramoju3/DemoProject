package com.thrivexcorp.prepview.controller;

import com.thrivexcorp.prepview.entity.FieldConfig;
import com.thrivexcorp.prepview.entity.ObjectConfig;
import com.thrivexcorp.prepview.service.FieldService;
import com.thrivexcorp.prepview.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EntityController {

    @Autowired
    private ObjectService objectService;

    @Autowired
    private FieldService fieldService;

    // Get an ObjectConfig by ID
    @GetMapping("/objects/{id}")
    public ResponseEntity<ObjectConfig> getObjectConfigById(@PathVariable UUID id) {
        Optional<ObjectConfig> objectConfig = objectService.getObjectById(id);
        return ResponseEntity.ok(objectConfig.get());
    }

    // Get all ObjectConfigs
    @GetMapping("/objects")
    public ResponseEntity<List<ObjectConfig>> getAllObjectConfigs() {
        List<ObjectConfig> objectConfigs = objectService.getAllObjects();
        return ResponseEntity.ok(objectConfigs);
    }

    // Get FieldConfigs by ObjectConfig ID
    @GetMapping("/object/{id}/fields")
    public ResponseEntity<List<FieldConfig>> getFieldByObjectId(@PathVariable UUID id) {
        List<FieldConfig> FieldConfigs = objectService.getFieldsByObjectId(id);
        return ResponseEntity.ok(FieldConfigs);
    }

    // Get all FieldConfigs
    @GetMapping("/fields")
    public ResponseEntity<List<FieldConfig>> getAllFieldConfigs() {
        List<FieldConfig> FieldConfigs = fieldService.getAllFields();
        return ResponseEntity.ok(FieldConfigs);
    }
    
    
    @PostMapping("/object/save")
    public ResponseEntity<ObjectConfig> createObjectConfig(@RequestBody ObjectConfig objectConfig) throws SQLException {
        return ResponseEntity.ok(objectService.createObject(objectConfig));
    }


    @PostMapping("object/field/save")
    public ResponseEntity<FieldConfig> createFieldConfig(@RequestBody FieldConfig fieldConfig) throws SQLException {
        return ResponseEntity.ok(fieldService.createField(fieldConfig));
    }




}
















