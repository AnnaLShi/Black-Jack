package GameSetup;


import GameSetup.CardBehaviour.Card;

import java.util.ArrayList;

public class Dealer {
    ArrayList<Card> hand;
    private PointCount pointCount;

    public Dealer() {
        this.hand = new ArrayList<Card>();
        this.pointCount = new PointCount();
    }
    public ArrayList<Card> getDealerHand () {
        return this.hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getPointCount() {
        return this.pointCount.add(this.hand);
    }

    public boolean checkBurst() {
        return getPointCount() > this.pointCount.getMaximumAmount();
    }
}
