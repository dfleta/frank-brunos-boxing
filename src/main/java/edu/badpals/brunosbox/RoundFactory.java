package edu.badpals.brunosbox;

public class RoundFactory {

    public static Round getRound(String roundScore){
    
        if (roundScore == null) { 
            return null;
        }
        if (!roundScore.contains(",")) {
            return new RegularRound(roundScore);
        } 
        else if (roundScore.equalsIgnoreCase("1, 8 - 10")) {
            return new PointsDeductedRed(roundScore);
        }
        else if (roundScore.equalsIgnoreCase("10 - 8 ,1")) {
            return new PointsDeductedBlue(roundScore);
        }
        return null;
    }
}
