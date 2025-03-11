package edu.badpals.brunosbox;

class PointsDeductedBlue extends PointsDeducted {

    PointsDeductedBlue(String roundScore) {
        super(roundScore);
    }

    void parseBoxerRoundScore() {
        String[] scores = getRoundScore().split("-", 2);
        String redBoxerRoundScore = scores[0];
        String blueBoxerRoundScore = scores[1];

        this.setRedBoxerScore(Byte.parseByte(redBoxerRoundScore));
        this.setBlueBoxerScore(this.parseComaBlue(blueBoxerRoundScore));
    }

    private Byte parseComaBlue(String score) {
        // score = "8,1"
        return Byte.parseByte(score.substring(0, score.indexOf(',')));
    }
}
