package edu.badpals.brunosbox;


class KnockdownRound implements Round {

    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    KnockdownRound(String roundScore) {
        this.roundScore = roundScore.replaceAll("\\s", "");
        this.boxerRoundScore();
    }

    String getRoundScore() {
        return this.roundScore;
    }

    void boxerRoundScore() {
        
        String redBoxerRoundScore = roundScore
                                    .substring(0, 
                                               this.roundScore.indexOf("-"));
        
        String blueBoxerRoundScore = roundScore
                                    .substring(this.roundScore.indexOf("-") + 1, 
                                               this.roundScore.length());

        this.redBoxerScore = Byte.parseByte(redBoxerRoundScore.toString());
        this.blueBoxerScore = Byte.parseByte(blueBoxerRoundScore.toString());
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