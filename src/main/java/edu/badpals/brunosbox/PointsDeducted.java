package edu.badpals.brunosbox;

abstract class PointsDeducted implements Round {

    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    PointsDeducted(String roundScore) {
        this.roundScore = roundScore.replaceAll("\\s", "");
        this.parseBoxerRoundScore();
    }

    String getRoundScore() {
        return this.roundScore;
    }

    abstract void parseBoxerRoundScore();

    @Override
    public byte getRedBoxerScore() {
        return this.redBoxerScore;
    }

    void setRedBoxerScore(byte score) {
        this.redBoxerScore = score;
    }

    @Override
    public byte getBlueBoxerScore() {
        return this.blueBoxerScore;
    }

    void setBlueBoxerScore(byte score) {
        this.blueBoxerScore = score;
    }

    @Override
    public String toString() {
        return this.getRedBoxerScore() + " - " + this.getBlueBoxerScore();
    }
    
}
