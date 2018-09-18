package GameSetup.CardBehaviour;

import enumCardTypes.*;

import java.io.FileReader;
import java.io.Reader;
import java.security.AlgorithmParameterGenerator;
import java.util.ArrayList;

public class CardDeck {
    private ArrayList<Card> cardDeck;
    private Rules rules;
    private boolean containsJoker;

    public CardDeck(Rules rules) {
        if (rules != null) {
            this.rules = rules;
            this.cardDeck = initCardDeck();
        }
        else {
            this.rules = new Rules();
            this.cardDeck = initCardDeck();
        }
    }

    public CardDeck() {
        this.rules = new Rules();
        this.cardDeck = initCardDeck();
    }

    public CardDeck(ArrayList<String> commands) {
        this.rules = new Rules();
        this.cardDeck = initCustomDeck(commands);
    }

    private ArrayList<Card> initCustomDeck(ArrayList<String> commands) {
        this.cardDeck = new ArrayList<Card>();
        for (String com: commands) {
            if (com.length() > 1 && !com.toUpperCase().equals(CardCommands.PS.getCommands()) && !com.toUpperCase().equals(CardCommands.DS.getCommands())) {
                this.cardDeck.add(findSpecifiedCard(com));
            }
        }

        return  this.cardDeck;
    }

    private Card findSpecifiedCard(String com) {
        Card card = new Card();
        String num = "";
        for (CardSuits suits: CardSuits.values()) {
                if (Character.toString(com.charAt(0)).equals(suits.getSuit())) {
         //          System.out.println(com.charAt(0));
                    card.setSuit(suits);
                }
        }

        for (int i = 1; i < com.length(); i++) {
            num += com.charAt(i);
        }

        for (CardValue value: CardValue.values()) {
            for (CardTypes types: CardTypes.values()) {
                if (value.name().equals(types.name()) && types.getCardType().equals(num)) {
                    card.setCardType(types);
                    card.setCardValue(value);
                }
            }
        }

        return card;
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

    public void deleteCard(int location) {
        this.cardDeck.remove(location);
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