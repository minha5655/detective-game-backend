package com.example.detective_game;

import com.example.detective_game.model.Clue;
import com.example.detective_game.repository.ClueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClueDataLoader {

    @Bean
    CommandLineRunner loadClues(ClueRepository clueRepository) {
        return args -> {

            if (clueRepository.count() > 0) {
                System.out.println("Clues already exist. Skipping clue creation.");
                return;
            }

            // CASE 1: The Missing Diamond
            addClue(clueRepository, 1L,
                    "A small piece of blue fabric was found near the broken display case.");
            addClue(clueRepository, 1L,
                    "Sarah was wearing a blue jacket that evening.");
            addClue(clueRepository, 1L,
                    "Security footage showed someone wearing blue near the diamond display.");

            // CASE 2: The Midnight Murder
            addClue(clueRepository, 2L,
                    "A heated argument took place in the victim's office earlier that evening.");
            addClue(clueRepository, 2L,
                    "Robert's fingerprints were found on a document beside the victim.");
            addClue(clueRepository, 2L,
                    "Robert had threatened to confront the businessman about a financial dispute.");

            // CASE 3: The Stolen Necklace
            addClue(clueRepository, 3L,
                    "A witness noticed someone near the jewellery box shortly before it disappeared.");
            addClue(clueRepository, 3L,
                    "Emily was seen leaving the room where the necklace had been kept.");
            addClue(clueRepository, 3L,
                    "A loose thread matching Emily's outfit was found beside the empty jewellery box.");

            System.out.println("Nine detective clues added successfully!");
        };
    }

    private void addClue(ClueRepository clueRepository, Long caseId, String description) {
        Clue clue = new Clue();
        clue.setCaseId(caseId);
        clue.setDescription(description);
        clueRepository.save(clue);
    }
}
