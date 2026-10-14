package com.example.detective_game;

import com.example.detective_game.model.Case;
import com.example.detective_game.model.Clue;
import com.example.detective_game.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cases")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Case> getAllCases() {
        return gameService.getAllCases();
    }

    @GetMapping("/{id}")
    public Case getCaseById(@PathVariable Long id) {
        return gameService.getCaseById(id);
    }

    @PostMapping
    public Case addCase(@RequestBody Case gameCase) {
        return gameService.addCase(gameCase);
    }

    @GetMapping("/{caseId}/clues")
    public List<Clue> getCluesForCase(@PathVariable Long caseId) {
        return gameService.getCluesForCase(caseId);
    }

    @PostMapping("/{caseId}/clues")
    public Clue addClue(
            @PathVariable Long caseId,
            @RequestBody Clue clue) {

        clue.setCaseId(caseId);

        return gameService.addClue(clue);
    }
}