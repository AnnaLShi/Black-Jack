package GameSetup.Screens;

import GameSetup.DealCard;
import Text_Based_UI.Display;
import Text_Based_UI.GameMessages;
import enumCardTypes.CardCommands;

import java.util.Scanner;

public class StartGame {

    public void run() {
        System.out.print(GameMessages.Game_started);
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        String cont;
        DealCard dealCard = new DealCard();
        game.run(dealCard);

        while (in.hasNext()) {
            cont = in.next();
            if (cont.toUpperCase().equals(CardCommands.NO.name()) || cont.toUpperCase().equals(CardCommands.NO.getCommands())) {
                Display.returnToMainMenu();
                break;
            }
            else if (cont.toUpperCase().equals(CardCommands.YES.name()) || cont.toUpperCase().equals(CardCommands.YES.getCommands())) {
                dealCard.resetDeckAndHands();
                game.run(dealCard);
            }
            else {
                System.out.println("Invalid Command Entered \n");
            }
        }

    }

    public boolean checkNo(String in){
        return false;
    }
    public boolean checkYes(String in) {
        return false;
    }

    public boolean invalidInput(String in) {
        return false;
    }
}
