package CardRules;

import enumCardTypes.CardRules;

import java.util.HashMap;

// This should call all valid Rules from RulesReader
// this should be a custom Map
public class Rules {
    private RulesReader reader;

    Rules(RulesReader reader) {
        this.reader = reader;
    }

    public HashMap<CardRules, String> getRules() {
        HashMap<CardRules, String> rulesSet = new HashMap<CardRules, String>();
        return null;
    }
}
