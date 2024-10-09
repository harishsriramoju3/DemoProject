package com.thrivexcorp.prepview.service.impl;

import com.thrivexcorp.prepview.entity.Template;
import com.thrivexcorp.prepview.repository.TemplateRepository;
import com.thrivexcorp.prepview.service.TemplateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public Template saveTemplate(Template template) {
        return templateRepository.save(template);
    }

    @Override
    public Template updateTemplate(UUID id, Template template) {
        Template existingTemplate = templateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Template not found with id: " + id));
        existingTemplate.setTitle(template.getTitle());
        existingTemplate.setDescription(template.getDescription());
        return templateRepository.save(existingTemplate);
    }

    @Override
    public void deleteTemplate(UUID id) {
        templateRepository.deleteById(id);
    }

    @Override
    public Template getTemplate(UUID id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Template not found with id: " + id));
    }

    @Override
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }
}
