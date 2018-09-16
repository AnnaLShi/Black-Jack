package GameSetup;

import GameSetup.CardBehaviour.Card;
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
        Scanner in = new Scanner(System.in);
        String inputStr;
        System.out.println(IntroScreenUI.introToGame);


        while (in.hasNext()) {
            // This is the intial screen of the the game
            inputStr = in.next();
            if (inputStr.toUpperCase().equals(CardCommands.HELP.getCommands()) || inputStr.toUpperCase().equals(CardCommands.HELP.name())) {
                System.out.println(IntroScreenUI.help_info);
            }

            if (inputStr.toUpperCase().equals(CardCommands.FILE.getCommands()) || inputStr.toUpperCase().equals(CardCommands.FILE.name())) {
                file_loader();
            }

            if (inputStr.toUpperCase().equals(CardCommands.CONSOLE.getCommands()) || inputStr.toUpperCase().equals(CardCommands.CONSOLE.name())) {
                start_game();
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
