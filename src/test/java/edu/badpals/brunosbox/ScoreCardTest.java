package edu.badpals.brunosbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreCardTest {

    private ScoreCard card;

    private String[] judgeScoreCard =  {"9 - 10", 
                                        "9 - 10", 
                                        "9 - 10", 
                                        "9 - 10",
                                        "10 - 9",
                                        "10 - 9",
                                        "10 - 9", 
                                        "9 - 10", 
                                        "10 - 9", 
                                        "9 - 10"};

    @BeforeEach
    public void setup() {
        card = new ScoreCard("white");
    }
    
    @Test
    public void loadJudgeScoreCardTest() {

        card.loadJudgeScoreCard(judgeScoreCard);
        assertEquals(10, card.getNumRounds());
        assertTrue(card.getRounds().stream().allMatch(a -> a instanceof Round));
        assertTrue(card.getRounds().stream().allMatch(a -> a instanceof RegularRound));
    } 

    @Test
    public void getBoxerFinalScoreTest() {
        assertEquals(0, card.getRedBoxerFinalScore());
        assertEquals(0, card.getBlueBoxerFinalScore());
        card.loadJudgeScoreCard(judgeScoreCard);
        assertEquals(94, card.getRedBoxerFinalScore());
        assertEquals(96, card.getBlueBoxerFinalScore());
    }
}
