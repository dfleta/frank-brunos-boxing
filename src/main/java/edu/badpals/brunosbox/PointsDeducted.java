package edu.badpals.brunosbox;

class PointsDeducted implements Round {

    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    PointsDeducted(String roundScore) {
        this.roundScore = roundScore.replaceAll("\\s", "");
        this.boxerRoundScore();
    }

    @Override
    public void boxerRoundScore() {
        
        String redBoxerRoundScore = this.roundScore.substring(0, this.roundScore.indexOf("-"));
        String blueBoxerRoundScore = this.roundScore.substring(this.roundScore.indexOf("-") + 1, this.roundScore.length());

        if (redBoxerRoundScore.indexOf(',') == -1) {
            this.redBoxerScore = Byte.parseByte(redBoxerRoundScore.toString());
            this.blueBoxerScore = this.parseComaBlue(blueBoxerRoundScore);
        } else {
            this.blueBoxerScore = Byte.parseByte(blueBoxerRoundScore.toString());
            this.redBoxerScore = this.parseComaRed(redBoxerRoundScore);
        }
    }

    private Byte parseComaBlue(String score) {
        // score = "8,1"
        return Byte.parseByte(score.substring(0, score.indexOf(',')));
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
        return new StringBuilder()
                    .append(this.redBoxerScore)
                    .append(" - ")
                    .append(this.blueBoxerScore).toString();
    }
    
}
