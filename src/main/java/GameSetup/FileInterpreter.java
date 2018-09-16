package GameSetup;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import enumCardTypes.CardCommands;

import java.util.ArrayList;

public class FileInterpreter {
    private FileReader file;
    private DealCard card;

    public FileInterpreter(FileReader reader) {
        this.file = reader;
        this.card = new DealCard(reader);
    }

    public void runFile() {
          this.card.givePlayersCards();
          identifyCommand();

    }

    public void identifyCommand() {
        for (String com: file.getCommands()) {

            System.out.println(com);
            if (com.toUpperCase().equals(CardCommands.HIT.getCommands())) {
                this.card.hitUserCalled();
            }
            else if (com.toUpperCase().equals(CardCommands.STAND.getCommands())) {
                this.card.playDealer();
            }
        }
    }

    public void fileHit() {
        card.hitUserCalled();
    }


    public void fileDealCards() {
        this.card.givePlayersCards();
    }

    public DealCard getDealCard(){
        return card;
    }

    public ArrayList<Card> getPreconfigedDeck() {
        return card.deckStatus();
    }

}
