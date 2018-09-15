package GameSetup;


import GameSetup.CardBehaviour.Card;


import java.util.ArrayList;

public class User {
    private ArrayList<Card> hand;
    private PointCount pointCount;

    public User() {
        this.hand = new ArrayList<Card>();
        this.pointCount = new PointCount();
    }


    public ArrayList<Card> getUserHand () {
        return hand;
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
