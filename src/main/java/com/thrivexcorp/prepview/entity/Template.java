package com.thrivexcorp.prepview.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
@Entity
@Table(name = "templates")
public class Template {

    @Column(name = "template_id")
    private UUID templateId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Section> sections;

    @Column(name = "deleted")
    private boolean isDeleted;
}
