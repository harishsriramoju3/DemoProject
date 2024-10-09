package com.thrivexcorp.prepview.service;

import com.thrivexcorp.prepview.entity.Section;

import java.util.List;
import java.util.UUID;

public interface SectionService {
    Section saveSection(Section section, UUID templateId);
    Section updateSection(UUID id, Section section);
    void deleteSection(UUID id);
    Section getSection(UUID id);
    List<Section> getSectionsByTemplate(UUID templateId);
}
