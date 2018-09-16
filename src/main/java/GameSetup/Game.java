package GameSetup;

import Text_Based_UI.Display;
import Text_Based_UI.GameMessages;
import Text_Based_UI.IntroScreenUI;
import enumCardTypes.CardCommands;

import java.util.Scanner;

public class Game {
    public Game() {
        super();
    }
    public void run(DealCard dealCard) {
        Scanner in = new Scanner(System.in);
        String inputStr;
        Display.displayGame(dealCard);


        if (dealCard.blackJackUserDealerEquals()) {
            dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
            Display.displayDealerBlackJack(dealCard);
            return;
        }
        if (dealCard.checkforBlackJackInUser()) {
            dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
            Display.displayUserBlackJack(dealCard);
            return;
        }


        while (in.hasNext()) {

            inputStr = in.next();

            if (inputStr.toUpperCase().equals(CardCommands.HIT.getCommands()) || inputStr.toUpperCase().equals(CardCommands.HIT.name())) {
                System.out.println(GameMessages.User_hit_called);
                dealCard.hitUserCalled();
            }

            if (inputStr.toUpperCase().equals(CardCommands.BACK.name()) || inputStr.toUpperCase().equals(CardCommands.BACK.getCommands())) {
                System.out.println(GameMessages.outline);
                System.out.println(IntroScreenUI.Back_To_Main_Menu);
                System.out.println(IntroScreenUI.introToGame_Hello);
                break;
            }

            if (dealCard.getUser().checkBurst()) {
                dealCard.getDealer().addPoints(dealCard.getDealer().getPointCount());
                Display.displayUserBustLosing(dealCard);
                break;
            }

            if (inputStr.toUpperCase().equals(CardCommands.STAND.name()) || inputStr.toUpperCase().equals(CardCommands.STAND.getCommands()) ) {

                dealCard.playDealer();

                if (dealCard.getDealer().checkBurst()) {
                    dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
                    Display.displayDealerBustLosing(dealCard);
                    break;
                }


                if (dealCard.getUser().getPointCount() > dealCard.getDealer().getPointCount()) {
                    dealCard.getUser().addPoints(dealCard.getUser().getPointCount());
                    Display.displayWinning(dealCard);
                    break;

                }

                if (dealCard.getUser().getPointCount() < dealCard.getDealer().getPointCount()) {
                    dealCard.getDealer().addPoints(dealCard.getDealer().getPointCount());
                    Display.displayLosing(dealCard);
                    break;

                }
                if (dealCard.getUser().getPointCount() == dealCard.getDealer().getPointCount()) {

                    dealCard.getDealer().addPoints(dealCard.getDealer().getPointCount());
                    Display.displayLosing(dealCard);
                    break;
                }

            }

            Display.displayGame(dealCard);
        }
    }
}
