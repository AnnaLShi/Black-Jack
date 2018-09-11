package CardRules;

import ReaderTypes.RulesReader;
import enumCardTypes.CardRules;

import java.util.HashMap;

// This should call all valid Rules from RulesReader
// this should be a custom Map
public class Rules {
    private RulesReader reader;

    public Rules(RulesReader reader) {
        this.reader = reader;
    }

    public Rules() {
        this.reader = null;
    }

    public HashMap<CardRules, Object> getRules() {
        if (reader == null) {
            // there is nothing configured.
            return getDefaultRules();
        }
        else {
            return getReaderRules();
        }
    }


    private HashMap<CardRules, Object> getReaderRules() {

        HashMap<CardRules, Object> rulesSet = new HashMap<CardRules, Object>();
        rulesSet.put(CardRules.DECK_SIZE, reader.deckSize());
        rulesSet.put(CardRules.HAS_JOKER, reader.hasJoker());
        return rulesSet;
    }

    private HashMap<CardRules, Object> getDefaultRules() {
        HashMap<CardRules, Object> rulesSet = new HashMap<CardRules, Object>();
        rulesSet.put(CardRules.DECK_SIZE, Integer.parseInt(CardRules.DECK_SIZE.getRulesConfig()));
        rulesSet.put(CardRules.HAS_JOKER, Boolean.parseBoolean(CardRules.HAS_JOKER.getRulesConfig().toLowerCase()));
        return rulesSet;
    }



    // test for valid rules write later.
}
