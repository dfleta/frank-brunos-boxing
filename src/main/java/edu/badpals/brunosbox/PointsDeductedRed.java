package edu.badpals.brunosbox;

class PointsDeductedRed extends PointsDeducted {

    PointsDeductedRed(String roundScore) {
        super(roundScore);
    }

    void parseBoxerRoundScore() {
        
        String[] scores = getRoundScore().split("-", 2);
        String redBoxerRoundScore = scores[0];
        String blueBoxerRoundScore = scores[1];

        this.setRedBoxerScore(this.parseComaRed(redBoxerRoundScore));
        this.setBlueBoxerScore(Byte.parseByte(blueBoxerRoundScore));
    }

    private Byte parseComaRed(String score) {
        // score = "1,8"
        return Byte.parseByte(score.substring(score.indexOf(',') + 1, score.length()));
    }    
}

