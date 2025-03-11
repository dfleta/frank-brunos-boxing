package edu.badpals.brunosbox;

class PointsDeductedBlue implements Round {

    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    PointsDeductedBlue(String roundScore) {
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

        this.redBoxerScore = Byte.parseByte(redBoxerRoundScore);
        this.blueBoxerScore = this.parseComaBlue(blueBoxerRoundScore);
    }

    private Byte parseComaBlue(String score) {
        // score = "8,1"
        return Byte.parseByte(score.substring(0, score.indexOf(',')));
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
