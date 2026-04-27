package edu.badpals.brunosbox;

public class RoundFactory {

    public static Round getRound(String roundScore){
    
        return switch (roundScore) { 
            case null -> null;
            case "10 - 9", "9 - 10" -> new RegularRound(roundScore) ;
            case "10 - 8", "8 - 10" -> new KnockdownRound(roundScore);
            case "1, 8 - 10", "10 - 8 ,1" -> new PointsDeducted(roundScore);
            default -> null;
        };
    }
}
