package GameSetup.Screens;

import GameSetup.DealCard;
import GameSetup.FileInterpreter;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import Text_Based_UI.GameMessages;
import Text_Based_UI.IntroScreenUI;
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
            else if (checkYes(cont)) {
                dealCard.resetDeckAndHands();
                game.run(dealCard);
            }
             invalidInput(cont);
        }
    }

    private void run(FileReader reader) {
        FileInterpreter file = new FileInterpreter(reader);
        file.runFile();
    }


    public boolean checkNo(String in){
        return (in.toUpperCase().equals(CardCommands.NO.name()) || in.toUpperCase().equals(CardCommands.NO.getCommands() ));
    }
    public boolean checkYes(String in) {
        return (in.toUpperCase().equals(CardCommands.YES.name()) || in.toUpperCase().equals(CardCommands.YES.getCommands()));

    }

    public boolean invalidInput(String in) {
        System.out.println(IntroScreenUI.invalid_message(in));
        return true;
    }
}
