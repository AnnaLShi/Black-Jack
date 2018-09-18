package GameSetup;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import Text_Based_UI.Display_FileInter;
import Text_Based_UI.FileInterpreterUI;
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
          System.out.println(FileInterpreterUI.fileGameStarted);
          Display_FileInter.displayResult(this.card);

          if (this.card.blackJackUserDealerEquals()) {
              this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
              Display.displayLosing(this.card);
              return;
          }

          if (this.card.checkforBlackJackInUser()) {
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              Display.displayUserBlackJack(this.card);
              return;
          }


          identifyCommand();

          if (this.card.getUser().checkBurst()) {
              this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
            Display.displayUserBustLosing(this.card);
            return;
          }
          if (this.card.getDealer().checkBurst()) {
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              Display.displayDealerBustLosing(this.card);
              return;
          }

          if (this.card.getUser().getPointCount() > this.card.getDealer().getPointCount()) {
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              Display_FileInter.displayWinning(this.card);
              return;

          }
            if (this.card.getUser().getPointCount() <= this.card.getDealer().getPointCount()) {
                this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
                Display_FileInter.displayLosing(this.card);
                return;
          }

    }

    public void identifyCommand() {
        for (String com: file.getCommands()) {

            if (com.toUpperCase().equals(CardCommands.HIT.getCommands())) {
                this.card.hitUserCalled();
                System.out.println(GameMessages.User_hit_called);
                Display.displayGame(this.card);
            }
            else if (com.toUpperCase().equals(CardCommands.DS.getCommands())) {

            }
            else if (com.toUpperCase().equals(CardCommands.PS.getCommands())) {

            }
            else if (com.toUpperCase().equals(CardCommands.STAND.getCommands())) {
                this.card.playDealer();
                System.out.println(GameMessages.User_Stands);
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
