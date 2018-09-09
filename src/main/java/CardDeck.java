import CardRules.Rules;
import enumCardTypes.CardRules;
import enumCardTypes.CardSuits;
import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;

import java.util.ArrayList;

public class CardDeck {
    private ArrayList<Card> cardDeck;
    private Rules rules;
    private boolean containsJoker;

    CardDeck(Rules rules) {
        if (rules != null) {
            this.rules = rules;
            this.cardDeck = initCardDeck();
        }
        else {
            this.rules = new Rules();
            this.cardDeck = initCardDeck();
        }
    }

    CardDeck() {
        this.rules = new Rules();
        this.cardDeck = initCardDeck();
    }


    private ArrayList<Card> initCardDeck() {
        cardDeck = new ArrayList<Card>();
        Card card;
        ArrayList<String> excludedCardTypes = getExcludedCardTypes();
        for (CardSuits suits: CardSuits.values()) {
            for (CardTypes types: CardTypes.values()) {
                for (CardValue value: CardValue.values()) {
                    if (value.name().equals(types.name()) && !excludedCardTypes.contains(value.name())) {
                        card = new Card(suits, value,types);
                        cardDeck.add(card);
                    }
                }
            }
        }
        return cardDeck;
    }

    private ArrayList<String> getExcludedCardTypes() {
        ArrayList<String> cardType = new ArrayList<String>();
        if (!Boolean.parseBoolean(rules.getRules().get(CardRules.HAS_JOKER).toString())) {
            cardType.add(CardTypes.JOKER.name());
            containsJoker = false;
        }

        return cardType;
    }



    public boolean hasJoker() {
        return containsJoker;
    }

    public int getSize() {
        return cardDeck.size();
    }

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }


    public Rules getDeckRules() {
            return rules;
    }


}