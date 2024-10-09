package com.thrivexcorp.prepview.service;

import com.thrivexcorp.prepview.entity.Template;

import java.util.List;
import java.util.UUID;

public interface TemplateService {
    Template saveTemplate(Template template);
    Template updateTemplate(UUID id, Template template);
    void deleteTemplate(UUID id);
    Template getTemplate(UUID id);
    List<Template> getAllTemplates();
}
