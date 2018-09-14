package GameSetup;

import CardBehaviour.Card;
import CardBehaviour.CardDeck;
import ReaderTypes.FileReader;
import Text_Based_UI.IntroScreenUI;
import enumCardTypes.CardCommands;

import java.util.ArrayList;
import java.util.Collections;
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
        CardDeck deck = new CardDeck();
        ArrayList<Card> shuffle_deck = deck.getCardDeck();
        Collections.shuffle(shuffle_deck);
        System.out.println(shuffle_deck.get(0).getCardType().getCardType());

    }

    private void start_game(FileReader reader) {



    }


    private void file_loader() {
        System.out.println(IntroScreenUI.file_info);
        Scanner in = new Scanner(System.in);
        String getFileName;
        FileReader reader;

        while (in.hasNext()) {
            getFileName = in.next();
            reader = new FileReader(getFileName);

            if (getFileName.equals("back")) {
                System.out.print(IntroScreenUI.Back_To_Main_Menu);
                System.out.println(IntroScreenUI.introToGame_Hello);
                break;
            }
            if (!reader.validateFileType()) {
                System.out.println(IntroScreenUI.file_invalid);
            }

            if (reader.validateFileType()) {
                System.out.print(IntroScreenUI.alt_successful_file(getFileName));
                start_game(reader);
            }

        }

    }
}
