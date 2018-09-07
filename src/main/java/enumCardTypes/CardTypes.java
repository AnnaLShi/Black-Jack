package enumCardTypes;

public enum CardTypes {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    JOKER("Jkr")  // not supose to to show up
    ;

    private String type;

    CardTypes(String type) {
        this.type = type;
    }

    public String getCardType() {
        return type;
    }
}
