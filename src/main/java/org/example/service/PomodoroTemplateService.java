package org.example.service;

import org.example.model.PomodoroTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.example.repository.PomodoroTemplateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PomodoroTemplateService {
    private final PomodoroTemplateRepository pomodoroTemplateRepository;

    @Autowired
    public PomodoroTemplateService(PomodoroTemplateRepository pomodoroTemplateRepository) {
        this.pomodoroTemplateRepository = pomodoroTemplateRepository;
    }

    public ResponseEntity<PomodoroTemplate> saveTemplate(@RequestBody PomodoroTemplate template) {
        PomodoroTemplate newTemplate = pomodoroTemplateRepository.save(template);
        return ResponseEntity.ok(newTemplate);
    }


    public ResponseEntity<List<PomodoroTemplate>> getAllTemplates() {
        return ResponseEntity.ok(pomodoroTemplateRepository.findAll());
    }

    public ResponseEntity<Optional<PomodoroTemplate>> getTemplateById(Long id) {
        Optional<PomodoroTemplate> existingTemplate = pomodoroTemplateRepository.findById(id);
        if (existingTemplate.isPresent()) {
            return ResponseEntity.ok(existingTemplate);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<PomodoroTemplate> updateTemplateById(Long id, PomodoroTemplate updatedTemplate) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "ID cannot be null");
        }
        Optional<PomodoroTemplate> existingTemplate = pomodoroTemplateRepository.findById(id);
        if(existingTemplate.isPresent()) {
            PomodoroTemplate template = existingTemplate.get();
            template.setWorkingDuration(updatedTemplate.getWorkingDuration());
            template.setBreakDuration(updatedTemplate.getBreakDuration());
            template.setRepetition(updatedTemplate.getRepetition());
            return ResponseEntity.ok(pomodoroTemplateRepository.save(template));
        }
        else {
            throw new RuntimeException("Template not found!");
        }
    }

    public ResponseEntity<String> deleteTemplate(Long id) {
        pomodoroTemplateRepository.deleteById(id);
        return ResponseEntity.ok("Product Deleted Successfully");
    }
}
