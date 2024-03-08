package edu.badpals.brunosbox;

public class ScoreCard {

    private final String color;
    private String rightCorner = "";
    private String leftCorner = "";
    
    public ScoreCard(String color) {
        this.color = color;
    }

    public void setRCorner(String boxerName) {
        this.rightCorner = boxerName;
    }

    public void setLCorner(String boxerName) {
        this.leftCorner = boxerName;
    };

    @Override
    public String toString() {
        return "\n\t\t\t" + this.color + 
                "\n\t" + this.leftCorner + "\t" + this.rightCorner;
    }
}
