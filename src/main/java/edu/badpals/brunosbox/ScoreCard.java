package edu.badpals.brunosbox;

import java.util.List;
import java.util.ArrayList;

public class ScoreCard {

    private final String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;
    private List<Round> rounds = new ArrayList<Round>();
    
    public ScoreCard(String color) {
        this.color = color;
    }

    public void setRCorner(String boxerName) {
        this.redCorner = boxerName;
    }

    public void setBCorner(String boxerName) {
        this.blueCorner = boxerName;
    };

    @Override
    public String toString() {
        return "\n\t\t\t" + this.color + 
                "\n\t" + this.blueCorner + "\t" + this.redCorner;
                // numero rounds
    }

    public void loadJugdeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
        this.scoreCardToRounds();
    }

    private void scoreCardToRounds() {
        for(String roundScore : this.judgeScoreCard) {
            this.rounds.add(RoundFactory.getRound(roundScore));
        }
    }
}
