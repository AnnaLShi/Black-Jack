package enumCardTypes;

public enum CardRules {
    DECK_SIZE("52"),

    HAS_JOKER("false"),
    HAS_DIAMONDS("false"),
    HAS_SPADES("false"),
    HAS_HEARTS("false"),
    HAS_CLUBS("false")
    ;

    private String defaultRules;

    CardRules(String defaultRules) {
        this.defaultRules = defaultRules;
    }

    public String getRulesConfig() {
        return defaultRules;
    }

}
