package com.thrivexcorp.prepview.service.impl;

import com.thrivexcorp.prepview.entity.Section;
import com.thrivexcorp.prepview.entity.Template;
import com.thrivexcorp.prepview.repository.SectionRepository;
import com.thrivexcorp.prepview.repository.TemplateRepository;
import com.thrivexcorp.prepview.service.SectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public Section saveSection(Section section, UUID templateId) {

        Template template = templateRepository.findById(templateId)
                .orElseThrow(() -> new EntityNotFoundException("Template not found with id: " + templateId));
        return sectionRepository.save(section);
    }

    @Override
    public Section updateSection(UUID id, Section section) {
        Section existingSection = sectionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Section not found with id: " + id));
        existingSection.setTitle(section.getTitle());
        existingSection.setDescription(section.getDescription());
        existingSection.setConfig(section.getConfig());
        existingSection.setSectionType(section.getSectionType());
        return sectionRepository.save(existingSection);
    }

    @Override
    public void deleteSection(UUID id) {
        sectionRepository.deleteById(id);
    }

    @Override
    public Section getSection(UUID id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Section not found with id: " + id));
    }

    @Override
    public List<Section> getSectionsByTemplate(UUID templateId) {
        return sectionRepository.findByTemplateId(templateId);
    }
}
