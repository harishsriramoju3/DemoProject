package com.thrivexcorp.prepview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "sections")
public class Section {

    @Column(name = "section_id")
    private UUID sectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    @JsonIgnore
    private Template template;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "config")
    private String config; // JSON config

    @Column(name = "config")
    private String sectionType;

    @Column(name = "deleted")
    private boolean isDeleted;

}
