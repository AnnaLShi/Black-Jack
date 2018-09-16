package GameSetup;


import GameSetup.CardBehaviour.Card;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;
    private PointCount pointCount;
    private int points;

    public Dealer() {
        this.hand = new ArrayList<Card>();
        this.pointCount = new PointCount();
        this.points = 0;
    }
    public ArrayList<Card> getDealerHand () {
        return this.hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(int i) {
        hand.remove(hand.get(i));
    }
    public int getPointCount() {
        return this.pointCount.add(this.hand);
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public boolean checkBurst() {
        return getPointCount() > this.pointCount.getMaximumAmount();
    }

    public void removeAllCards() {
        this.hand.clear();
        this.hand = new ArrayList<Card>();
    }
}
