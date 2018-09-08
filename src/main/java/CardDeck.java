import enumCardTypes.CardRules;

import java.util.ArrayList;
import java.util.HashMap;

public class CardDeck {
    private ArrayList<Card> cardDeck;
    private HashMap<CardRules, Object> rules;

    CardDeck(HashMap<CardRules, Object> rules) {
        this.rules = rules;
        this.cardDeck = initCardDeck();
    }

    private ArrayList<Card> initCardDeck() {
        return null;
    }

    public boolean hasJoker() {
        return true;
    }

    public int getSize() {
        return -1;
    }

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    public String displayRandomClassUsed() {
        return null;
    }

    public HashMap<CardRules, Object> getRules() {
            return null;
    }


}