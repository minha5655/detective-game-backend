package com.example.detective_game;

import com.example.detective_game.model.Clue;
import com.example.detective_game.repository.ClueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClueDataLoader {

```
@Bean
CommandLineRunner loadClues(ClueRepository clueRepository) {
    return args -> {

        addCluesForCase(clueRepository, 1L,
            "A small piece of blue fabric was found near the diamond display.",
            "Sarah was wearing a blue jacket that evening.",
            "Security footage showed someone wearing blue near the display.");

        addCluesForCase(clueRepository, 2L,
            "A heated argument took place in the victim's office.",
            "Robert's fingerprints were found on a document beside the victim.",
            "Robert had a financial dispute with the businessman.");

        addCluesForCase(clueRepository, 3L,
            "A witness noticed someone near the jewellery box.",
            "Emily was seen leaving the room where the necklace was kept.",
            "A loose thread matching Emily's outfit was found beside the box.");

        System.out.println("Clue loading process completed.");
    };
}

private void addCluesForCase(
        ClueRepository repository,
        Long caseId,
        String clue1,
        String clue2,
        String clue3) {

    if (!repository.findByCaseId(caseId).isEmpty()) {
        System.out.println("Clues already exist for case " + caseId);
        return;
    }

    saveClue(repository, caseId, clue1);
    saveClue(repository, caseId, clue2);
    saveClue(repository, caseId, clue3);

    System.out.println("Added three clues for case " + caseId);
}

private void saveClue(
        ClueRepository repository,
        Long caseId,
        String description) {

    Clue clue = new Clue();
    clue.setCaseId(caseId);
    clue.setDescription(description);

    repository.save(clue);
}
```

}
