package edu.badpals.brunosbox;

class RegularRound implements Round {

    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;


    RegularRound(String roundScore) {
        this.roundScore = roundScore.replaceAll("\\s", "");
        this.boxerRoundScore();
    }

    String getRoundScore() {
        return this.roundScore;
    }

    void boxerRoundScore() {
        
        String redBoxerRoundScore = roundScore.substring(0, this.roundScore.indexOf("-"));
        String blueBoxerRoundScore = roundScore.substring(this.roundScore.indexOf("-") + 1, this.roundScore.length());

        this.redBoxerScore = Byte.parseByte(redBoxerRoundScore.toString());
        this.blueBoxerScore = Byte.parseByte(blueBoxerRoundScore.toString());
    }

    byte getRedBoxerScore() {
        return this.redBoxerScore;
    }

    byte getBlueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public String toString() {
        return this.redBoxerScore + " - " + this.blueBoxerScore;
    }

}
