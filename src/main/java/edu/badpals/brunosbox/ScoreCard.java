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

    public byte getNumRounds() {
        return (byte) this.rounds.size();
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    @Override
    public String toString() {
        return "\n\t\t   " + this.color + 
                "\n\t" + this.blueCorner + "\t" + this.redCorner +
                "\n\t\t" + this.getNumRounds() + " rounds\n" +
                this.viewRounds();
            
                // numero rounds
    }

    public void loadJugdeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;

        for(String roundScore : this.judgeScoreCard) {
            this.rounds.add(RoundFactory.getRound(roundScore));
        }
    }

    private String viewRounds() {
        String view = "\t Round Score" + "\tRound" + "\tRound Score" ;
        byte roundNum = 1;
        for(Round round : this.rounds) {
            view += "\n\t\t" + round.getRedBoxerScore() + "\t" + roundNum + "\t" + round.getBlueBoxerScore();
        }
        return view;
    }
}
