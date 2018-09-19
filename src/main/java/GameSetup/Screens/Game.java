package GameSetup.Screens;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import GameSetup.Players.PointCount;
import GameSetup.User;
import Text_Based_UI.Display;
import Text_Based_UI.GameMessages;
import Text_Based_UI.IntroScreenUI;
import enumCardTypes.CardCommands;

import java.util.Scanner;

public class Game {
    private PointCount count = new PointCount();
    boolean hasSplit;
    public Game() {
        super();
    }
    public void run(DealCard dealCard) {
        Scanner in = new Scanner(System.in);
        String inputStr;
        PointCount count = new PointCount();
        int point_to_card_loc = 0;
        Display.displayGame(dealCard, false, false);


        if (dealCard.blackJackUserDealerEquals()) {
            dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
            Display.displayDealerBlackJack(dealCard, false);
            return;
        }
        if (dealCard.checkforBlackJackInUser()) {
            dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
            Display.displayUserBlackJack(dealCard, false);
            return;
        }

        while (in.hasNext()) {

            inputStr = in.next();

            if (inputStr.toUpperCase().equals(CardCommands.HIT.getCommands()) || inputStr.toUpperCase().equals(CardCommands.HIT.name())) {
                if (point_to_card_loc == 0) {
                    dealCard.hitUserCalled();
                }
                else if (point_to_card_loc == 1) {
                    dealCard.hitUserhand2Called();
                }
            }
            if (inputStr.toUpperCase().equals(CardCommands.PLAYERSPLITS.getCommands()) || inputStr.toUpperCase().equals(CardCommands.PLAYERSPLITS.name())) {
                if (dealCard.isUserSplitable()) {
                    dealCard.userSplit();
                }

            }

            if (inputStr.toUpperCase().equals(CardCommands.BACK.name()) || inputStr.toUpperCase().equals(CardCommands.BACK.getCommands())) {
                System.out.println(GameMessages.outline);
                System.out.println(IntroScreenUI.Back_To_Main_Menu);
                System.out.println(IntroScreenUI.introToGame_Hello);
                break;
            }

            else if (dealCard.getUser().checkBurst()) {
                dealCard.getDealer().addPoints(dealCard.getDealer().getPointCount());
                dealCard.getDealer().addPoints(dealCard.getDealer().getPointHand2Count());
                Display.displayUserBustLosing(dealCard, dealCard.isHasSplitUser());
                break;
            }

            else if ( (inputStr.toUpperCase().equals(CardCommands.STAND.name()) || inputStr.toUpperCase().equals(CardCommands.STAND.getCommands()))){
                dealCard.playDealer();

                if (dealCard.isHasSplitUser() && point_to_card_loc != 1) {
                    System.out.println("Moving to next hand...");
                    point_to_card_loc = 1;
                    continue;
                }

                if (dealCard.getDealer().checkBurst()) {
                    dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
                    dealCard.getUser().addPoints(dealCard.getUser().getPointHand2Count());
                    Display.displayDealerBustLosing(dealCard, dealCard.isHasSplitUser());
                    break;
                }


                else if (checkUserWinning(dealCard)) {
                    dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
                    Display.displayWinning(dealCard, dealCard.isHasSplitUser());
                    break;

                }

                else if (checkDealerWinning(dealCard)) {
                    dealCard.getDealer().addPoints(dealCard.getDealer().getPointCount());
                    dealCard.getDealer().addPoints(dealCard.getDealer().getPointHand2Count());
                    Display.displayLosing(dealCard,  dealCard.isHasSplitUser());
                    break;

                }

            }


            Display.displayGame(dealCard, dealCard.isHasSplitUser(), dealCard.isHasDealerSplit());
        }
    }

    private boolean checkUserWinning(DealCard dealCard) {
        return dealCard.getUser().getPointCount() > dealCard.getDealer().getPointCount()
                || count.add(dealCard.getUser().getHands()) > dealCard.getDealer().getPointCount()
                && dealCard.getUser().getPointCount() > count.add(dealCard.getDealer().getHands());
    }

    private boolean checkDealerWinning(DealCard dealCard) {
            return dealCard.getUser().getPointCount() <= dealCard.getDealer().getPointCount()
                    || count.add(dealCard.getUser().getHands()) <= dealCard.getDealer().getPointCount()
                    && dealCard.getUser().getPointCount() <= count.add(dealCard.getDealer().getHands());
    }
}
