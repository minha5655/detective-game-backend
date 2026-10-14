package com.example.detective_game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game_cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String story;
    private String suspect1;
    private String suspect2;
    private String suspect3;
    private String suspect4;
    private String correctAnswer;

    public Case() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getSuspect1() {
        return suspect1;
    }

    public void setSuspect1(String suspect1) {
        this.suspect1 = suspect1;
    }

    public String getSuspect2() {
        return suspect2;
    }

    public void setSuspect2(String suspect2) {
        this.suspect2 = suspect2;
    }

    public String getSuspect3() {
        return suspect3;
    }

    public void setSuspect3(String suspect3) {
        this.suspect3 = suspect3;
    }

    public String getSuspect4() {
        return suspect4;
    }

    public void setSuspect4(String suspect4) {
        this.suspect4 = suspect4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}