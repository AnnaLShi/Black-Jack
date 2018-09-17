package GameSetup;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import Text_Based_UI.GameMessages;
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

          if (this.card.blackJackUserDealerEquals()) {
              this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
              Display.displayLosing(this.card);
              return;
          }
          if (this.card.checkforBlackJackInUser()) {
              Display.displayUserBlackJack(this.card);
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              return;
          }


          identifyCommand();
          if (this.card.getUser().checkBurst()) {
            Display.displayUserBustLosing(this.card);
            return;
          }
          if (this.card.getDealer().checkBurst()) {
              Display.displayDealerBustLosing(this.card);
              return;
          }

          if (this.card.getUser().getPointCount() > this.card.getDealer().getPointCount()) {
              Display.displayWinning(this.card);
              return;

          }
            if (this.card.getUser().getPointCount() <= this.card.getDealer().getPointCount()) {
            Display.displayLosing(this.card);
            return;
          }
          //Display.displayGame(this.card);
          //Display.displayGame(this.card);

    }

    public void identifyCommand() {
        for (String com: file.getCommands()) {

            if (com.toUpperCase().equals(CardCommands.HIT.getCommands())) {
                System.out.println(GameMessages.User_hit_called);
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
