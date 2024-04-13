package org.example.controller;

import org.example.model.PomodoroTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.service.PomodoroTemplateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PomodoroTemplateController {
    private final PomodoroTemplateService pomodoroTemplateService;

    @Autowired
    public PomodoroTemplateController(PomodoroTemplateService pomodoroTemplateService) {
        this.pomodoroTemplateService = pomodoroTemplateService;
    }

    @PostMapping("/template")
    public ResponseEntity<PomodoroTemplate> saveTemplate(@RequestBody PomodoroTemplate template) {
        PomodoroTemplate pomodoroTemplate = pomodoroTemplateService.saveTemplate(template).getBody();
        return ResponseEntity.ok(pomodoroTemplate);
    }

    @GetMapping("/templates")
    public ResponseEntity<List<PomodoroTemplate>> getAllTemplates() {
        return pomodoroTemplateService.getAllTemplates();
    }

    @GetMapping("/template/{id}")
    public ResponseEntity<PomodoroTemplate> getTemplateById(@PathVariable Long id) {
        Optional<PomodoroTemplate> template = pomodoroTemplateService.getTemplateById(id).getBody();
        return template.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("template/{id}")
    public ResponseEntity<PomodoroTemplate> updateTemplateById(@PathVariable Long id, @RequestBody PomodoroTemplate updatedTemplate) {
        PomodoroTemplate template = pomodoroTemplateService.updateTemplateById(id, updatedTemplate).getBody();
        return ResponseEntity.ok(template);
    }

    @DeleteMapping("template/{id}")
    public ResponseEntity<String> deleteTemplate(@PathVariable Long id) {
        pomodoroTemplateService.deleteTemplate(id);
        return ResponseEntity.ok("Product Deleted Successfully");
    }
}
