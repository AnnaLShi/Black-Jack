package Text_Based_UI;

import GameSetup.DealCard;


// this shows all the display classes
public class Display {
    public static void displayGame(DealCard dealCard) {
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.examCard);
        System.out.println(GameMessages.dealerCards(dealCard.getDealer().getDealerHand().size()));
        System.out.println(GameMessages.amountWorth( dealCard.getUser().getPointCount()));
        System.out.println(GameMessages.displayPlayerCards(dealCard));
        System.out.println(GameMessages.User_Options);
    }

    public static void displayResult(DealCard dealCard) {
        System.out.println(GameMessages.outline);
        System.out.println("Dealer " + GameMessages.amountWorth(dealCard.getDealer().getPointCount()));
        System.out.println(GameMessages.displayDealerCards(dealCard));
        System.out.println("User " + GameMessages.amountWorth(dealCard.getUser().getPointCount()));
        System.out.println(GameMessages.displayPlayerCards(dealCard));
    }

    public static void displayWinning(DealCard dealCard) {
        displayResult(dealCard);
        System.out.println(GameMessages.win);
    }

    public static void displayLosing(DealCard dealCard) {
        displayResult(dealCard);
        System.out.println(GameMessages.lost);
    }

    public static void returnToMainMenu() {
        System.out.println(GameMessages.outline);
        System.out.print(IntroScreenUI.Back_To_Main_Menu);
        System.out.println(IntroScreenUI.introToGame_Hello);
    }

}
