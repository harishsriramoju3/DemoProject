package com.thrivexcorp.prepview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "fields")
public class FieldConfig extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)  // Load ObjectConfig lazily
    @JoinColumn(name = "object_id", nullable = false)
    @JsonIgnore
    private ObjectConfig objectConfig;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "source_type")
    private String sourceType;

    @Column(name = "field_type", nullable = false)
    private String fieldType; // VARCHAR, INT, BOOLEAN, etc.

    @Column(name = "default_value")
    private String defaultValue;

    @Column(name = "required")
    private boolean required;

    @Column(name = "length")
    private Integer length;

    @Column(name = "scale")
    private Integer scale;


    public String getObjectId() {
        return objectConfig != null ? objectConfig.getId().toString() : null;
    }
}
