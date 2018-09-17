package GameSetup.Screens;

import GameSetup.DealCard;
import ReaderTypes.FileReader;
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
            if (checkNo(cont)) {
                Display.returnToMainMenu();
                break;
            }
            else if (checkYes(cont)) {
                dealCard.resetDeckAndHands();
                game.run(dealCard);
            }
            else if (invalidInput(cont)){
                System.out.println("Invalid Command Entered \n");
            }
        }

    }

    public void run(FileReader reader) {

    }
    public boolean checkNo(String in){
        return (in.toUpperCase().equals(CardCommands.NO.name()) || in.toUpperCase().equals(CardCommands.NO.getCommands()));
    }
    public boolean checkYes(String in) {
        return (in.toUpperCase().equals(CardCommands.YES.name()) || in.toUpperCase().equals(CardCommands.YES.getCommands()));
    }

    public boolean invalidInput(String in) {
        return true;
    }
}
