package edu.badpals.brunosbox;

class PointsDeductedRed implements Round {

    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    PointsDeductedRed(String roundScore) {
        this.roundScore = roundScore.replaceAll("\\s", "");
        this.parseBoxerRoundScore();
    }

    String getRoundScore() {
        return this.roundScore;
    }

    private void parseBoxerRoundScore() {
        
        String[] scores = getRoundScore().split("-", 2);
        String redBoxerRoundScore = scores[0];
        String blueBoxerRoundScore = scores[1];

        this.redBoxerScore = this.parseComaRed(redBoxerRoundScore);
        this.blueBoxerScore = Byte.parseByte(blueBoxerRoundScore);
    }

    private Byte parseComaRed(String score) {
        // score = "1,8"
        return Byte.parseByte(score.substring(score.indexOf(',') + 1, score.length()));
    }

    @Override
    public byte getRedBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public byte getBlueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public String toString() {
        return this.getRedBoxerScore() + " - " + this.getBlueBoxerScore();
    }
    
}

