package edu.badpals.brunosbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreCardTest {

    private ScoreCard card;

    private String[] whiteScoreCard =  {"9 - 10", 
                                        "9 - 10", 
                                        "9 - 10", 
                                        "9 - 10",
                                        "10 - 9",
                                        "10 - 9",
                                        "10 - 9", 
                                        "9 - 10", 
                                        "10 - 9", 
                                        "9 - 10"};

    private String[] pinkScoreCard = {"9 - 10", 
                                        "9 - 10", 
                                        "9 - 10", 
                                        "1, 8 - 10", // referee point deduction
                                        "10 - 8",    // knockdown
                                        "10 - 8 ,1", // referee point deduction
                                        "10 - 9", 
                                        "9 - 10", 
                                        "10 - 9", 
                                        "10 - 8"}; // knockdown

    @BeforeEach
    public void setup() {
        card = new ScoreCard("white");
    }
    
    @Test
    public void loadJudgeScoreCardRoundFactoryRegularTest() {

        card.loadJudgeScoreCard(whiteScoreCard);
        assertEquals(10, card.getNumRounds());
        assertTrue(card.getRounds().stream().allMatch(a -> a instanceof RegularRound));
    } 

    @Test
    public void loadJudgeScoreCardRoundFactoryNullTest() {
        card.loadJudgeScoreCard(new String[]{null, null});
        assertEquals(0, card.getNumRounds());
    }

    @Test
    public void loadJudgeScoreCardRoundFactoryPointsDeductedTest() {

        card.loadJudgeScoreCard(pinkScoreCard);
        assertEquals(10, card.getNumRounds());
        assertEquals(2, card.getRounds().stream().filter(a -> a instanceof PointsDeducted).count());
    }


    @Test
    public void loadJudgeScoreCardRoundFactoryKnockDownTest() {

        card.loadJudgeScoreCard(pinkScoreCard);
        assertEquals(10, card.getNumRounds());
        assertEquals(2, card.getRounds().stream().filter(a -> a instanceof KnockdownRound).count());
    }

    @Test
    public void getBoxerFinalScoreTest() {
        assertEquals(0, card.getRedBoxerFinalScore());
        assertEquals(0, card.getBlueBoxerFinalScore());
        card.loadJudgeScoreCard(whiteScoreCard);
        assertEquals(94, card.getRedBoxerFinalScore());
        assertEquals(96, card.getBlueBoxerFinalScore());
    }
}
