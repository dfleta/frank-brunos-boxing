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
    }
    public byte getNumRounds() {
        return (byte) this.rounds.size();
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    @Override
    public String toString() {
        return "\n\t\t\t   " + this.color + 
                "\n\t\t" + this.blueCorner + "\t" + this.redCorner +
                "\n\t\t\t" + this.getNumRounds() + " rounds\n" +
                this.viewRounds();
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;

        for(String roundScore : this.judgeScoreCard) {
            this.rounds.add(RoundFactory.getRound(roundScore));
        }
    }

    public int getRedBoxerFinalScore() {
        return this.getRounds()
                    .stream()
                    .map(Round::getRedBoxerScore)
                    .map(Byte::intValue)
                    .reduce(0, Integer::sum);
    }

    public int getBlueBoxerFinalScore() {
        return this.getRounds()
                    .stream()
                    .map(Round::getBlueBoxerScore)
                    .map(Byte::intValue)
                    .reduce(0, Integer::sum);
    }

    private String viewRounds() {
        
        String view = "\t Round \t Score \t Round \t Score \t Round\n" +
                      "\t Score \t Total \t       \t Total \t Score";
        
        byte roundNum = 1;
        
        byte redBoxerScoreTotal = 0;
        byte blueBoxerScoreTotal = 0;

        for(Round round : this.rounds) {
            view += String.format("\n\t %d \t %d \t %d \t %d \t %d", 
                    round.getRedBoxerScore(),
                    redBoxerScoreTotal += round.getRedBoxerScore(),
                    roundNum++, 
                    blueBoxerScoreTotal += round.getBlueBoxerScore(),
                    round.getBlueBoxerScore()); 
        }
        return view;
    }
}
