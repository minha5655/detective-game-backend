package com.example.detective_game;

import com.example.detective_game.model.Case;
import com.example.detective_game.repository.CaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseDataLoader {

    @Bean
    CommandLineRunner loadCases(CaseRepository caseRepository) {
        return args -> {

            if (caseRepository.count() > 0) {
                return;
            }

            Case case1 = new Case();

            case1.setTitle("The Missing Diamond");
            case1.setStory(
                "A priceless diamond disappeared from a locked museum " +
                "room at 9 PM. The security guard heard glass breaking. " +
                "Four people were present, but only one is responsible."
            );
            case1.setSuspect1("John");
            case1.setSuspect2("Sarah");
            case1.setSuspect3("Michael");
            case1.setSuspect4("Emma");
            case1.setCorrectAnswer("Sarah");

            caseRepository.save(case1);


            Case case2 = new Case();

            case2.setTitle("The Midnight Murder");
            case2.setStory(
                "A businessman was found dead in his office at midnight. " +
                "The detective discovered that the victim had argued " +
                "with one of four suspects earlier that evening."
            );
            case2.setSuspect1("David");
            case2.setSuspect2("Olivia");
            case2.setSuspect3("Robert");
            case2.setSuspect4("Sophia");
            case2.setCorrectAnswer("Robert");

            caseRepository.save(case2);


            Case case3 = new Case();

            case3.setTitle("The Stolen Necklace");
            case3.setStory(
                "A valuable necklace vanished during a party. " +
                "The doors were watched all night, so the thief " +
                "must have been someone already inside the house."
            );
            case3.setSuspect1("Daniel");
            case3.setSuspect2("Emily");
            case3.setSuspect3("James");
            case3.setSuspect4("Isabella");
            case3.setCorrectAnswer("Emily");

            caseRepository.save(case3);

            System.out.println("Three detective cases added successfully!");
        };
    }
}
