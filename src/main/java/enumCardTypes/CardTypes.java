package enumCardTypes;

public enum CardTypes {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    JOKER(14)
    ;

    private int type;

    CardTypes(int type) {
        this.type = type;
    }

    public int getCardType() {
        return type;
    }
}
