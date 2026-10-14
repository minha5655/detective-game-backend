package com.example.detective_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long caseId;

    private String description;

    public Clue() {
    }

    public Long getId() {
        return id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}