package Text_Based_UI;

import GameSetup.DealCard;
import GameSetup.Players.PointCount;
import GameSetup.Screens.Game;


// this shows all the display classes
public class Display {
    private  PointCount count = new PointCount();

    public static void displayGame(DealCard dealCard, boolean isSplit, boolean dealerSplit) {
        PointCount count = new PointCount();

        System.out.println(GameMessages.outline);

        System.out.println(GameMessages.dealerPoints(dealCard.getDealer().getPoints()));
        System.out.println(GameMessages.examCard);
        System.out.println(GameMessages.dealerCards(dealCard.getDealer().getHand()));
        if (dealerSplit) {
            System.out.println(GameMessages.amountWorth(count.add(dealCard.getDealer().getHands())));
            System.out.println(GameMessages.displayDealerCards(dealCard, dealerSplit));
        }

        System.out.println(GameMessages.userPoints(dealCard.getUser().getPoints()));
        System.out.println(GameMessages.amountWorth( dealCard.getUser().getPointCount()));
        System.out.println(GameMessages.displayPlayerCards(dealCard, false));
        if (isSplit) {
            System.out.println(GameMessages.amountWorth(count.add(dealCard.getUser().getHands())));
            System.out.println(GameMessages.displayPlayerCards(dealCard, isSplit));
        }

        if (dealCard.isUserSplitable()) {
            System.out.println(GameMessages.User_Options + "Or Split(D)");
        }
        System.out.println(GameMessages.User_Options);
    }

    public static void displayResult(DealCard dealCard,  boolean isSplit) {

        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.dealerPoints(dealCard.getDealer().getPoints()));
        System.out.println("Dealer " + GameMessages.amountWorth(dealCard.getDealer().getPointCount()));
        System.out.println(GameMessages.displayDealerCards(dealCard, dealCard.isHasDealerSplit()));

        System.out.println(GameMessages.userPoints(dealCard.getUser().getPoints()));
        System.out.println("User " + GameMessages.amountWorth(dealCard.getUser().getPointCount()));
        System.out.println(GameMessages.displayPlayerCards(dealCard, isSplit));
        if (isSplit) {
            System.out.println(GameMessages.amountWorth(dealCard.getUser().getPointHand2Count()));
            System.out.println(GameMessages.displayPlayerCards(dealCard, isSplit));
        }
    }

    public static void displayWinning(DealCard dealCard, boolean isSplit) {
        displayResult(dealCard, isSplit);
        System.out.println(GameMessages.win);
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.contPlay);
    }

    public static void displayLosing(DealCard dealCard,  boolean isSplit) {
        displayResult(dealCard, isSplit);
        System.out.println(GameMessages.lost);
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.contPlay);
    }

    public static void displayDealerBustLosing(DealCard dealCard,  boolean isSplit) {
        displayResult(dealCard, isSplit);
        System.out.println(GameMessages.Dealer_busts);
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.contPlay);
    }

    public static void displayUserBustLosing(DealCard dealCard,  boolean isSplit) {
        displayResult(dealCard, isSplit);
        System.out.println(GameMessages.User_busts);
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.contPlay);
    }

    public static void returnToMainMenu() {
        System.out.println(GameMessages.outline);
        System.out.print(IntroScreenUI.Back_To_Main_Menu);
        System.out.println(IntroScreenUI.introToGame_Hello);
    }

    public static void displayUserBlackJack(DealCard dealCard,  boolean isSplit) {
        displayResult(dealCard, isSplit);
        System.out.println(GameMessages.BJ_win_user);
        System.out.println(GameMessages.contPlay);
    }


    public static void displayDealerBlackJack(DealCard dealCard,  boolean isSplit) {
        displayResult(dealCard, isSplit);
        System.out.println(GameMessages.BJ_win_dealer);
        System.out.println(GameMessages.contPlay);
    }

    public static void displayUserSplitHand(DealCard dealCard) {

        PointCount count = new PointCount();
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.dealerPoints(dealCard.getDealer().getPoints()));
        System.out.println("Dealer " + GameMessages.amountWorth(dealCard.getDealer().getPointCount()));
        System.out.println(GameMessages.displayDealerCards(dealCard, dealCard.isHasDealerSplit()));

        System.out.println(GameMessages.userPoints(dealCard.getUser().getPoints()));
        System.out.println("User hand 1: " + GameMessages.amountWorth(dealCard.getUser().getPointCount()));
        System.out.println(GameMessages.displayPlayerCards(dealCard, false));
        System.out.println("User hand 2: " + GameMessages.amountWorth(count.add(dealCard.getUser().getHands())));
        System.out.println(GameMessages.displayPlayerCards(dealCard, true));
    }

}
