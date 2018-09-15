package GameSetup;


import GameSetup.CardBehaviour.Card;

import java.util.ArrayList;

public class Dealer {
    ArrayList<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<Card>();

    }
    public ArrayList<Card> getDealerHand () {
        return this.hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
}
