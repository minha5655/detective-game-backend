package com.example.detective_game.service;

import com.example.detective_game.model.Case;
import com.example.detective_game.model.Clue;
import com.example.detective_game.repository.CaseRepository;
import com.example.detective_game.repository.ClueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final CaseRepository caseRepository;
    private final ClueRepository clueRepository;

    public GameService(CaseRepository caseRepository, ClueRepository clueRepository) {
        this.caseRepository = caseRepository;
        this.clueRepository = clueRepository;
    }

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public Case getCaseById(Long id) {
        return caseRepository.findById(id).orElse(null);
    }

    public Case addCase(Case gameCase) {
        return caseRepository.save(gameCase);
    }

    public List<Clue> getCluesForCase(Long caseId) {
        return clueRepository.findByCaseId(caseId);
    }

    public Clue addClue(Clue clue) {
        return clueRepository.save(clue);
    }
}