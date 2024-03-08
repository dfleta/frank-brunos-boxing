package edu.badpals.brunosbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ScoreCardTest {
    
    @Test
    public void loadJugdeScoreCardTest() {
        ScoreCard card = new ScoreCard("white");

        String[] judgeScoreCard =  {"9 - 10", 
                                    "9 - 10", 
                                    "9 - 10", 
                                    "9 - 10",
                                    "10 - 9",
                                    "10 - 9",
                                    "10 - 9", 
                                    "9 - 10", 
                                    "10 - 9", 
                                    "10 - 9"};

        card.loadJugdeScoreCard(judgeScoreCard);
        assertEquals(10, card.getNumRounds());
        assertTrue(card.getRounds().stream().allMatch(a -> a instanceof Round));
        assertTrue(card.getRounds().stream().allMatch(a -> a instanceof RegularRound));
    } 
}
