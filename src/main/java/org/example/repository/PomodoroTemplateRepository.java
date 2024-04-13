package org.example.repository;

import org.example.model.PomodoroTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomodoroTemplateRepository extends JpaRepository<PomodoroTemplate, Long>  {
}
