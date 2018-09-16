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
        DealCard dealCard = new DealCard();
        Scanner in = new Scanner(System.in);
        PointCount count = new PointCount();
        String inputStr;
        CardCommands commands;
        System.out.print(GameMessages.Game_started);
        Display.displayGame(dealCard);


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
                Display.displayResult(dealCard);
                System.out.println(GameMessages.User_busts);
                break;
            }

            if (inputStr.toUpperCase().equals(CardCommands.STAND.name()) || inputStr.toUpperCase().equals(CardCommands.STAND.getCommands()) ) {

                dealCard.playDealer();

                if (dealCard.getDealer().checkBurst()) {
                    Display.displayResult(dealCard);
                    System.out.println(GameMessages.Dealer_busts);
                    break;
                }


                if (dealCard.getUser().getPointCount() > dealCard.getDealer().getPointCount()) {
                    Display.displayWinning(dealCard);
                    break;

                }

                if (dealCard.getUser().getPointCount() < dealCard.getDealer().getPointCount()) {
                    Display.displayLosing(dealCard);
                    break;

                }
                if (dealCard.getUser().getPointCount() == dealCard.getDealer().getPointCount()) {
                    Display.displayLosing(dealCard);
                    break;
                }

            }


            Display.displayGame(dealCard);
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
