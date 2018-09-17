package GameSetup;

import GameSetup.Screens.FileScreen;
import GameSetup.Screens.StartGame;

import GameSetup.Screens.StartScreen;
import ReaderTypes.DirectoryReader;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import Text_Based_UI.GameMessages;
import Text_Based_UI.IntroScreenUI;
import enumCardTypes.CardCommands;

import java.util.Scanner;

public class LoadGame {
    public LoadGame() {
        super();
    }

    public void start_application() {

        StartScreen start = new StartScreen();
        start.showStartIntroduction();

        Scanner in = new Scanner(System.in);
        String inputStr;

        while (in.hasNext()) {
            // This is the intial screen of the the game
            inputStr = in.next();
            if (start.isHelpChosen(inputStr)) {
            }

            else if (start.isFileChose(inputStr)) {
                FileScreen fileScreen = new FileScreen();
                fileScreen.run();
            }

            else if (start.isConsoleChosen(inputStr)) {
                StartGame startGame = new StartGame();
                startGame.run();
            }
            else if (start.isQuitChosen(inputStr)) {
                break;
            }
            else if (start.isInvalidInput(inputStr)) {

            }
        }
    }
}
