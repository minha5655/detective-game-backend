package com.example.detective_game;

import com.example.detective_game.model.Case;
import com.example.detective_game.repository.CaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseDataLoader {

```
@Bean
CommandLineRunner loadCases(CaseRepository caseRepository) {
    return args -> {
        if (caseRepository.count() == 0) {

            Case case1 = new Case();
            case1.setTitle("The Missing Diamond");
            case1.setStory("A diamond disappeared from a locked mansion room at 9 PM. Four people were nearby. The gardener says he was watering plants, the chef was preparing dinner, the maid was cleaning the hallway, and the butler was serving tea. A wet footprint was found inside the room.");
            case1.setSuspect1("The Gardener");
            case1.setSuspect2("The Chef");
            case1.setSuspect3("The Maid");
            case1.setSuspect4("The Butler");
            case1.setCorrectAnswer("The Gardener");
            caseRepository.save(case1);

            Case case2 = new Case();
            case2.setTitle("The Stolen Painting");
            case2.setStory("A valuable painting vanished from an art gallery during a power outage. The guard claims nobody entered, but muddy footprints were discovered beneath the gallery's open window. The gardener had been working outside in the rain.");
            case2.setSuspect1("The Guard");
            case2.setSuspect2("The Artist");
            case2.setSuspect3("The Gardener");
            case2.setSuspect4("The Manager");
            case2.setCorrectAnswer("The Gardener");
            caseRepository.save(case2);

            Case case3 = new Case();
            case3.setTitle("The Midnight Mystery");
            case3.setStory("At midnight, a priceless watch disappeared from a study. The owner heard the clock strike twelve, but the clock had stopped at eleven. The butler was the only person who knew the clock was broken.");
            case3.setSuspect1("The Butler");
            case3.setSuspect2("The Driver");
            case3.setSuspect3("The Cook");
            case3.setSuspect4("The Neighbor");
            case3.setCorrectAnswer("The Butler");
            caseRepository.save(case3);
        }
    };
}
```

}
