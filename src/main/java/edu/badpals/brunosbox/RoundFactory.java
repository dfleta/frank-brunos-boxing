package edu.badpals.brunosbox;

public class RoundFactory {

    private static final char POINTS_DEDUCTED_MARK = ',';
    private static final char ROUND_POINTS_MARK = '-';

    public static Round getRound(String roundScore){
    
        if (roundScore == null) { 
            return null;
        }
        if (roundScore.indexOf(POINTS_DEDUCTED_MARK) == -1) {
            return new RegularRound(roundScore);
        } 
        else if (roundScore.indexOf(POINTS_DEDUCTED_MARK) < roundScore.indexOf(ROUND_POINTS_MARK)) {
            return new PointsDeductedRed(roundScore);
        }
        else if (roundScore.indexOf(POINTS_DEDUCTED_MARK) > roundScore.indexOf(ROUND_POINTS_MARK)) {
            return new PointsDeductedBlue(roundScore);
        }
        return null;
    }
}
