package GameSetup;

import ReaderTypes.DirectoryReader;
import ReaderTypes.FileReader;
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
        DealCard dealCard = new DealCard();
        Scanner in = new Scanner(System.in);
        String inputStr;
        CardCommands commands;
        System.out.print(GameMessages.Game_started);
        displayGame(dealCard);

        while (in.hasNext()) {
            inputStr = in.next();
            if (inputStr.toUpperCase().equals(CardCommands.HIT.getCommands()) || inputStr.toUpperCase().equals(CardCommands.HIT.name())) {
                System.out.println(GameMessages.User_hit_called);
                dealCard.hitCalled();
            }
            if (inputStr.toUpperCase().equals(CardCommands.BACK.name()) || inputStr.toUpperCase().equals(CardCommands.BACK.getCommands())) {
                System.out.println(GameMessages.outline);
                System.out.println(IntroScreenUI.Back_To_Main_Menu);
                System.out.println(IntroScreenUI.introToGame_Hello);
                break;
            }


            displayGame(dealCard);
        }

    }

    private void displayGame(DealCard dealCard) {
        System.out.println(GameMessages.outline);
        System.out.println(GameMessages.examCard);
        System.out.println(GameMessages.dealerCards(dealCard.getDealer().getDealerHand().size()));
        System.out.println(GameMessages.displayPlayerCards(dealCard));
        System.out.println(GameMessages.User_Options);
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
                System.out.println(GameMessages.outline);
                System.out.print(IntroScreenUI.Back_To_Main_Menu);
                System.out.println(IntroScreenUI.introToGame_Hello);
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
