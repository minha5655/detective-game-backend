package com.example.detective_game;

import com.example.detective_game.model.Case;
import com.example.detective_game.model.Clue;
import com.example.detective_game.repository.CaseRepository;
import com.example.detective_game.repository.ClueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.List;

@Configuration
public class CaseDataLoader {

    @Bean
    CommandLineRunner loadGameData(CaseRepository caseRepository,
                                   ClueRepository clueRepository) {
        return args -> {

            // 1. Add the three cases only if the table is empty
            if (caseRepository.count() == 0) {
                caseRepository.save(createCase(
                        "The Missing Diamond",
                        "A priceless blue diamond vanished from the city museum during a private evening event. "
                                + "The display case was found broken, and only four people had access to the room.",
                        "Sarah", "Daniel", "Priya", "Marcus",
                        "Sarah"));

                caseRepository.save(createCase(
                        "The Midnight Murder",
                        "A wealthy businessman was found dead in his office just after midnight. "
                                + "Four people had a reason to be in the building that night.",
                        "Robert", "Linda", "James", "Olivia",
                        "Robert"));

                caseRepository.save(createCase(
                        "The Stolen Necklace",
                        "A family heirloom necklace disappeared from a locked jewellery box during a dinner party. "
                                + "Four guests were in the house when it vanished.",
                        "Emily", "Henry", "Grace", "Victor",
                        "Emily"));

                System.out.println("Three detective cases added successfully!");
            }

            // 2. Add the clues only if there are none yet.
            //    Clues are attached to the real case ids, in id order.
            if (clueRepository.count() == 0) {
                List<Case> cases = caseRepository.findAll(Sort.by("id"));

                if (cases.size() < 3) {
                    System.out.println("Fewer than 3 cases found. Skipping clue creation.");
                    return;
                }

                Long case1 = cases.get(0).getId();
                Long case2 = cases.get(1).getId();
                Long case3 = cases.get(2).getId();

                // CASE 1: The Missing Diamond
                addClue(clueRepository, case1,
                        "A small piece of blue fabric was found near the broken display case.");
                addClue(clueRepository, case1,
                        "Sarah was wearing a blue jacket that evening.");
                addClue(clueRepository, case1,
                        "Security footage showed someone wearing blue near the diamond display.");

                // CASE 2: The Midnight Murder
                addClue(clueRepository, case2,
                        "A heated argument took place in the victim's office earlier that evening.");
                addClue(clueRepository, case2,
                        "Robert's fingerprints were found on a document beside the victim.");
                addClue(clueRepository, case2,
                        "Robert had threatened to confront the businessman about a financial dispute.");

                // CASE 3: The Stolen Necklace
                addClue(clueRepository, case3,
                        "A witness noticed someone near the jewellery box shortly before it disappeared.");
                addClue(clueRepository, case3,
                        "Emily was seen leaving the room where the necklace had been kept.");
                addClue(clueRepository, case3,
                        "A loose thread matching Emily's outfit was found beside the empty jewellery box.");

                System.out.println("Nine detective clues added successfully!");
            } else {
                System.out.println("Clues already exist. Skipping clue creation.");
            }
        };
    }

    private Case createCase(String title, String story,
                            String suspect1, String suspect2,
                            String suspect3, String suspect4,
                            String correctAnswer) {
        Case gameCase = new Case();
        gameCase.setTitle(title);
        gameCase.setStory(story);
        gameCase.setSuspect1(suspect1);
        gameCase.setSuspect2(suspect2);
        gameCase.setSuspect3(suspect3);
        gameCase.setSuspect4(suspect4);
        gameCase.setCorrectAnswer(correctAnswer);
        return gameCase;
    }

    private void addClue(ClueRepository clueRepository, Long caseId, String description) {
        Clue clue = new Clue();
        clue.setCaseId(caseId);
        clue.setDescription(description);
        clueRepository.save(clue);
    }
}
