package org.example.model;
import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
@Table(name = "pomodoroTemplate")

public class PomodoroTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long workingDuration;

    @Column(nullable = false)
    private long breakDuration;

    @Column(nullable = false)
    private long repetition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkingDuration() {
        return workingDuration;
    }

    public void setWorkingDuration(long workingDuration) {
        this.workingDuration = workingDuration;
    }

    public long getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(long breakDuration) {
        this.breakDuration = breakDuration;
    }

    public long getRepetition() {
        return repetition;
    }

    public void setRepetition(long repetition) {
        this.repetition = repetition;
    }

//
//    public PomodoroTemplate save(PomodoroTemplate template) {
//        this.setId(template.id);
//        this.setWorkingDuration(template.workingDuration);
//        this.setBreakDuration(template.breakDuration);
//        this.setRepetition(template.repetition);
//
//        return this;
//    }
}
