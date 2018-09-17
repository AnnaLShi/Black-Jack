package GameSetup;


import GameSetup.Screens.Game;
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
                file_loader();
            }

            else if (start.isConsoleChosen(inputStr)) {
                start_game();
            }
            else if (start.isQuitChosen(inputStr)) {
                break;
            }
            else if (start.isInvalidInput(inputStr)) {

            }
        }
    }

    private void start_game() {
        // shuffle the deck, this will have to implement the AI of the dealer
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



    private void start_game(FileReader reader) {
        FileInterpreter file = new FileInterpreter(reader);
        file.runFile();
    }


    private void file_loader() {
        System.out.println(IntroScreenUI.file_info);
        Scanner in = new Scanner(System.in);
        String getFileName;
        FileReader reader;
        DirectoryReader directory;

        directory = new DirectoryReader("files");
        System.out.println(directory.printArrayListFiles());

        while (in.hasNext()) {
            getFileName = in.next();
            reader = new FileReader(getFileName);
            if (getFileName.toUpperCase().equals(CardCommands.BACK.name()) || getFileName.toUpperCase().equals(CardCommands.BACK.getCommands())) {
                Display.returnToMainMenu();
                break;
            }
            if (!reader.validateFileType()) {
                System.out.println(IntroScreenUI.file_invalid);
                directory = new DirectoryReader("files");
                System.out.println(directory.printArrayListFiles());

            }

            if (reader.validateFileType()) {
                System.out.print(IntroScreenUI.alt_successful_file(getFileName));
                start_game(reader);
            }

        }

    }
}
