package GameSetup;

import GameSetup.CardBehaviour.Card;

import java.util.ArrayList;

public class User {
    private ArrayList<Card> hand;

    public User() {
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getUserHand () {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
}
