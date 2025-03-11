package edu.badpals.brunosbox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointsDeductedTest {

    @Test
    public void replaceTest() {
        PointsDeductedBlue roundB = new PointsDeductedBlue("10 - 8 ,1");
        assertEquals(roundB.getRoundScore(), "10-8,1");
        PointsDeductedRed roundR = new PointsDeductedRed("1, 8 - 10");
        assertEquals(roundR.getRoundScore(), "1,8-10");
    }

    @Test
    public void roundScoreToIntBlueTest() {
        PointsDeductedBlue round = new PointsDeductedBlue("10 - 8 ,1");
        assertEquals(round.getRoundScore(), "10-8,1");
        assertEquals(10, round.getRedBoxerScore());
        assertEquals(8, round.getBlueBoxerScore());
    }

    @Test
    public void roundScoreToIntRedTest() {
        PointsDeductedRed round = new PointsDeductedRed("1, 8 - 10");
        assertEquals(round.getRoundScore(), "1,8-10");
        assertEquals(8, round.getRedBoxerScore());
        assertEquals(10, round.getBlueBoxerScore());
    }
    
}
