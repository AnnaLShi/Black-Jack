package Text_Based_UI;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;

public class GameMessages {

    // Messages
    public final static String Game_started = "Game Started\n";
    public final static String User_hit_called = "User has called hit \n";
    public final static String Stand_called = "Stand Called \n";
    public final static String MaxWinningPoints= "You have 21 points, You can only S (Stand) \n";
    public final static String User_busts = "You've gone over 21 points, You Lose \n";
    public final static String Dealer_busts = "Dealer busts, You win \n";
    public final static String User_Options = "Would you Hit (H) or Stand (S)?";


    // Board
    public final static String outline = "------------------------------------------------------------------";

    // Card Info display
    public final static String examCard = "Type out you card to examine value of card as displayed. \n";

    public final static String displayPlayerCards(DealCard dealCard) {
        String display = "";
        for (Card card: dealCard.getUser().getUserHand()) {
            display += card.getCardSuit() + card.getCardType().getCardType() + " ";
        }
        return  "Your Cards: " + display + "\n";
    }

    public final static String displayDealerCards(DealCard dealCard) {
        String display = "";
        for (Card card: dealCard.getDealer().getDealerHand()) {
            display += card.getCardSuit() + card.getCardType().getCardType() + " ";
        }
        return  "Dealer Cards: " + display + "\n";
    }

    public final static String getCardFullName(String string) {
        return "Card: " + string + "\n";
    }

    public final static String amountWorth(int amount) {
        return "Card Total " + amount;
    }
        //dealer
    public final static String dealerCards(int size) {
        String mystery = "";

        for (int j = 0; j < size; j++) {
            mystery += " ??";
        }
        return "Dealer hand: " + mystery + "\n";

    }

    // Points

    public final static String userPoints(int i) {
        return "User Points:" + i;
    }

    public final static String dealerPoints(int i) {
        return "Dealer Points" + i;
    }

    public final static String lost= "You lose \n";
    public final static String win = "You win \n";

}
