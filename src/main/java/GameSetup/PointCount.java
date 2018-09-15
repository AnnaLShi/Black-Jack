package GameSetup;

import GameSetup.CardBehaviour.Card;

import java.util.ArrayList;

public class PointCount {
    private int maximumAmount = 21;

    public PointCount() {
        super();
    }

    public int add(ArrayList<Card> cards) {
        int total_points = 0;
        if (cards == null) {
            return -1;
        }
        // check for two aces
        for (Card card: cards ) {
            if (card.getPointValue().name().equals("ACE")) {
                if (total_points < maximumAmount && total_points + card.getPointValue().getCardValue()[1] < maximumAmount) {
                    total_points += card.getPointValue().getCardValue()[1];
                }
                else {
                    total_points += card.getPointValue().getCardValue()[0];
                }
            }
            else {
                total_points += card.getPointValue().getCardValue()[0];
            }
        }
        return total_points;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
