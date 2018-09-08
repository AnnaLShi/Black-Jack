package CardRules;

import enumCardTypes.CardRules;

import java.util.HashMap;

// This should call all valid Rules from RulesReader
// this should be a custom Map
public class Rules {
    private RulesReader reader;

    public Rules(RulesReader reader) {
        this.reader = reader;
    }

    public HashMap<CardRules, Object> getValidRules() {
        HashMap<CardRules, Object> rulesSet = new HashMap<CardRules, Object>();
        rulesSet.put(CardRules.DECK_SIZE, reader.deckSize());
        rulesSet.put(CardRules.HAS_JOKER, reader.hasJoker());
        return rulesSet;
    }


    // test for valid rules write later.
}
