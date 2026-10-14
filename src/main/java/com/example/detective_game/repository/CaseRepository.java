package com.example.detective_game.repository;

import com.example.detective_game.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}