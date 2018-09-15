package enumCardTypes;

public enum CardSuits{
    DIAMOND("D"),
    HEART("H"),
    CLUBS("C"),
    SPADES("S");

    private String getSuit;

    CardSuits(String getSuit) {
        this.getSuit = getSuit;
    }

    public String getSuit() {
        return getSuit;
    }
}