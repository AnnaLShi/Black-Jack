package Text_Based_UI;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;

import java.util.ArrayList;

public class GameMessages {

    // Messages
    public final static String Game_started = "Game Started\n";
    public final static String User_hit_called = "User has called hit \n";
    public final static String Stand_called = "Stand Called \n";
    public final static String MaxWinningPoints= "You have 21 points, You can only S (Stand) \n";
    public final static String User_busts = "You've gone over 21 points, You Lose \n";
    public final static String Dealer_busts = "Dealer busts, You win \n";
    public final static String User_Options = "Would you Hit (H) or Stand (S)?";
    public final static String User_Stands = "User Stands";

    // Board
    public final static String outline = "------------------------------------------------------------------";

    // Card Info display
    public final static String examCard = "Type out you card to examine value of card as displayed. \n";

    public final static String displayPlayerCards(DealCard dealCard, boolean displaySplithand) {
        String display = "";
        if (displaySplithand) {
            for (Card card : dealCard.getUser().getHands()) {
                display += card.getCardSuit() + card.getCardType().getCardType() + " ";
            }
            return "Your Cards: " + display + "\n";
        }
        else {
            for (Card card : dealCard.getUser().getHand()) {
                display += card.getCardSuit() + card.getCardType().getCardType() + " ";
            }
            return  "Your Cards: " + display + "\n";
        }
    }

    public final static String displayDealerCards(DealCard dealCard, boolean splitHands) {
        String display = "";
        if (splitHands) {
            for (Card card : dealCard.getDealer().getHands()) {
                display += card.getCardSuit() + card.getCardType().getCardType() + " ";
            }

        }
        else {
            for (Card card : dealCard.getDealer().getHand()) {
                display += card.getCardSuit() + card.getCardType().getCardType() + " ";
            }
        }
        return  "Dealer Cards: " + display + "\n";
    }

    public final static String displayOneUnkownDealerCards(DealCard dealCard) {
        String display = "";
        for (Card card: dealCard.getDealer().getHand()) {
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
    public final static String dealerCards(ArrayList<Card> cards) {
        String mystery = "";

        for (int j = 0; j < cards.size(); j++) {
            if (j == 0) {
                mystery += cards.get(j).getCardSuit() + cards.get(j).getCardType().getCardType();
            }
            else {
                mystery += " ??";
            }
        }
        return "Dealer hand: " + mystery + "\n";

    }

    // Points

    public final static String userPoints(int i) {
        return "                                            User Points: "  + i;
    }

    public final static String dealerPoints(int i) {
        return "                                            Dealer Points: " + i;
    }

    public final static String lost= "You lose \n";
    public final static String win = "You win \n";
    public final static String BJ_win_user = "User got Black Jack, you win \n";

    public final static String BJ_win_dealer = "Dealer Got Black Jack, you lose \n";


    // continue playing

    public  final static String contPlay = "Would you like to continue play? \n";

}
