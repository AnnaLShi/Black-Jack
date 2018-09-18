package Text_Based_UI;


import GameSetup.DealCard;

// this stores all the text files for all the UI for just the file
// this is the only text that is used in the
public final class Display_FileInter {

    public static void displayResult(DealCard dealCard) {
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.dealerPoints(dealCard.getDealer().getPoints()));
        System.out.println("Dealer " + GameMessages.amountWorth(dealCard.getDealer().getPointCount()));
        System.out.println(GameMessages.displayDealerCards(dealCard));

        System.out.println(GameMessages.userPoints(dealCard.getUser().getPoints()));
        System.out.println("User " + GameMessages.amountWorth(dealCard.getUser().getPointCount()));
        System.out.println(GameMessages.displayPlayerCards(dealCard));
    }

    public static void displayWinning(DealCard dealCard) {
        displayResult(dealCard);
        System.out.println(GameMessages.win);
        System.out.println(GameMessages.outline);
        System.out.println(FileInterpreterUI.continueTestingFiles);
    }

    public static void displayLosing(DealCard dealCard) {
        displayResult(dealCard);
        System.out.println(GameMessages.lost);
        System.out.println(GameMessages.outline);
        System.out.println(FileInterpreterUI.continueTestingFiles);
    }


}

