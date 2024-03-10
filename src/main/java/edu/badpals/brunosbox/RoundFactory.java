package edu.badpals.brunosbox;

public class RoundFactory {

    public static Round getRound(String roundScore){
    
        if (roundScore == null) { 
            return null;
        } 
        if (roundScore.equalsIgnoreCase("10 - 9") || roundScore.equalsIgnoreCase("9 - 10")) {
            return new RegularRound(roundScore);
        } 
        else if (roundScore.equalsIgnoreCase("10 - 8") || roundScore.equalsIgnoreCase("8 - 10")) {
            return new KnockdownRound(roundScore);
        } 
        else if (roundScore.equalsIgnoreCase("")) {
            return null; // new PointsDeducted();
        }
        return null;
    }
}
