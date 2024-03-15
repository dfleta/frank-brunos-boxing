package edu.badpals.brunosbox;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreCard {

    private final String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;
    private Byte redBoxerFinalScore = 0;
    private Byte blueBoxerFinalScore = 0;

    private List<Round> rounds = new ArrayList<Round>();
    
    public ScoreCard(String color) {
        this.color = color;
    }

    public void setRCorner(String boxerName) {
        this.redCorner = boxerName;
    }

    public void setBCorner(String boxerName) {
        this.blueCorner = boxerName;
    }
    public byte getNumRounds() {
        return (byte) this.rounds.size();
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(this.rounds);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                    .append("\n\t\t\t   ")
                    .append(this.color)
                    .append("\n\t\t")
                    .append(this.blueCorner)
                    .append("\t")
                    .append(this.redCorner)
                    .append("\n\t\t\t")
                    .append(this.getNumRounds())
                    .append(getNumRounds())
                    .append(" rounds\n")
                    .append(this.viewRounds()).toString();
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;

        for(String roundScore : this.judgeScoreCard) {
            this.rounds.add(RoundFactory.getRound(roundScore));
        }
    }

    public byte getRedBoxerFinalScore() {
        if (this.redBoxerFinalScore == 0) {
            this.redBoxerFinalScore =
                this.getRounds()
                    .stream()
                    .map(Round::getRedBoxerScore)
                    .map(Byte::intValue)
                    .reduce(0, Integer::sum)
                    .byteValue();
        }
        return this.redBoxerFinalScore;
    }

    public int getBlueBoxerFinalScore() {
        if (this.blueBoxerFinalScore == 0) {
            this.getRounds()
                .stream()
                .map(Round::getBlueBoxerScore)
                .map(Byte::intValue)
                .reduce(0, Integer::sum);
        }
        return this.blueBoxerFinalScore;
    }

    private String viewRounds() {
        
        StringBuilder roundsView = new StringBuilder();
        roundsView.append("\tRound \t Score \t Round \t Score \t Round\n")
                  .append("\tScore \t Total \t       \t Total \t Score");
        
        byte roundNum = 1;
        
        byte redBoxerScoreTotal = 0;
        byte blueBoxerScoreTotal = 0;

        for(Round round : this.rounds) {
            roundsView.append("\n\t")
                .append(round.getRedBoxerScore())
                .append("\t\s")
                .append(redBoxerScoreTotal += round.getRedBoxerScore())
                .append("\t\s\s")
                .append(roundNum++)
                .append("\t\s")
                .append(blueBoxerScoreTotal += round.getBlueBoxerScore())
                .append("\t\s")
                .append(round.getBlueBoxerScore());       
        }
        return roundsView.toString();
    }
}
