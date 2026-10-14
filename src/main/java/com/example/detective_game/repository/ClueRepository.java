package com.example.detective_game.repository;

import com.example.detective_game.model.Clue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClueRepository extends JpaRepository<Clue, Long> {

    List<Clue> findByCaseId(Long caseId);
}