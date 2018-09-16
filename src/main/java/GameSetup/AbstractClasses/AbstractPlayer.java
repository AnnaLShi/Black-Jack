package GameSetup.AbstractClasses;

import GameSetup.CardBehaviour.Card;
import GameSetup.PointCount;

import java.util.ArrayList;

public abstract class AbstractPlayer {
    private ArrayList<Card> hand;
    private PointCount pointCount;
    private int points;

    public AbstractPlayer() {
        this.hand = new ArrayList<Card>();
        this.pointCount = new PointCount();
        this.points = 0;
    }

    public ArrayList<Card> getHand () {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
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

    public void removeCard(int i) {
        hand.remove(hand.get(i));
    }
}
