package com.thrivexcorp.prepview.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Data
@Getter
@Setter
@Entity
@Table(name = "objects")
public class ObjectConfig  extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "object_name")
    private String objectName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "source_type")
    private String sourceType;

    @Column(name = "description")
        private String description;

    @OneToMany(mappedBy = "objectConfig", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FieldConfig> fields;

}