package GameSetup.Players.AbstractClasses;

import GameSetup.CardBehaviour.Card;
import GameSetup.Players.PointCount;

import java.util.ArrayList;


public abstract class AbstractPlayer {
    private ArrayList<Card> hand2;
    private ArrayList<Card> hand;
    private PointCount pointCount;
    private int points;
    private boolean lasthand;
    public AbstractPlayer() {
        this.hand = new ArrayList<Card>();
        this.hand2 = null;
        this.lasthand = true;
        this.pointCount = new PointCount();
        this.points = 0;
    }


    public void setUpSplit() {
        // get the first card
        this.hand2 = new ArrayList<Card>();
        this.hand2.add(this.hand.get(1));
        this.hand.remove(1);
    }

    public boolean isLasthand() {
        return this.lasthand;
    }

    public void setLastHand(boolean lastHand) {
        this.lasthand = lasthand;
    }

    public ArrayList<Card> getHands () {
        return this.hand2;
    }

    public ArrayList<Card> getHand() {return this.hand;}


    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void addCardHand2(Card card) {
        this.hand2.add(card);
    }

    public int getPointCount() {
        return this.pointCount.add(this.hand);
    }

    public int getPointHand2Count() {
        return this.pointCount.add(this.hand2);
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public boolean checkBurst() {
        return getPointCount() > this.pointCount.getMaximumAmount() || pointCount.add(this.hand2) > this.pointCount.getMaximumAmount();
    }

    public void removeCard(int i) {
        hand.remove(hand.get(i));
    }

    public void removeAllCards() {
        this.hand.clear();
    }
}
