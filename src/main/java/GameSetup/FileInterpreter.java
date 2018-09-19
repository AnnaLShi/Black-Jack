package GameSetup;

import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import GameSetup.Players.PointCount;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import Text_Based_UI.Display_FileInter;
import Text_Based_UI.FileInterpreterUI;
import Text_Based_UI.GameMessages;
import enumCardTypes.CardCommands;

import java.util.ArrayList;
import java.util.Collections;

public class FileInterpreter {
    private FileReader file;
    private DealCard card;
    private boolean hasSplitUser;

    public FileInterpreter(FileReader reader) {
        this.file = reader;
        this.card = new DealCard(reader);
    }

    public void runFile() {


          if (this.card.blackJackUserDealerEquals()) {
              this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
              this.card.getDealer().addPoints(this.card.getDealer().getPointHand2Count());
              Display.displayLosing(this.card, false);
              return;
          }

          if (this.card.checkforBlackJackInUser()) {
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              this.card.getUser().addPoints(this.card.getUser().getPointHand2Count());
              Display.displayUserBlackJack(this.card, false);
              return;
          }
        System.out.println(FileInterpreterUI.fileGameStarted);
        Display.displayGame(this.card, false, false);
          identifyCommand();

          if (this.card.getUser().checkBurst()) {
              this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
              this.card.getDealer().addPoints(this.card.getDealer().getPointHand2Count());
              Display.displayUserBustLosing(this.card, this.card.isHasSplitUser());
            return;
          }
          if (this.card.getDealer().checkBurst()) {
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              this.card.getUser().addPoints(this.card.getUser().getPointHand2Count());
              Display.displayDealerBustLosing(this.card, this.card.isHasSplitUser());
              return;
          }

          if (checkUserWinning()) {
              this.card.getUser().addPoints(this.card.getUser().getPointCount());
              this.card.getUser().addPoints(this.card.getUser().getPointHand2Count());
              Display.displayWinning(this.card, this.card.isHasSplitUser());
              return;

          }
          if (checkDealerWinning()) {
                this.card.getDealer().addPoints(this.card.getDealer().getPointCount());
                this.card.getDealer().addPoints(this.card.getDealer().getPointHand2Count());
                Display.displayLosing(this.card,  this.card.isHasSplitUser());
                return;
          }
    }

    public void identifyCommand() {
        int point_to_card_loc = 0;

        for (String com: file.getCommands()) {

            if (com.toUpperCase().equals(CardCommands.HIT.getCommands())) {
                if(point_to_card_loc == 0) {
                    this.card.hitUserCalled();
                    System.out.println(GameMessages.User_hit_called);
                    Display.displayGame(this.card, this.card.isHasSplitUser(), this.card.isHasDealerSplit());
                }
                else {
                    this.card.hitUserhand2Called();
                }
            }
            else if (com.toUpperCase().equals(CardCommands.PLAYERSPLITS.getCommands())) {
                hasSplitUser = true;
                this.card.userSplit();
                Display.displayGame(this.card, this.card.isHasSplitUser(), this.card.isHasDealerSplit());
            }
            else if (com.toUpperCase().equals(CardCommands.STAND.getCommands())) {
                Display.displayGame(this.card, this.card.isHasSplitUser(), this.card.isHasDealerSplit());
                if (this.card.isHasSplitUser() && point_to_card_loc != 1) {
                    point_to_card_loc = 1;
                    continue;
                }
                this.card.playDealer();
                System.out.println(GameMessages.User_Stands);
            }
        }
    }

    public boolean getHasUserSplit() {
        return hasSplitUser;
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

    private boolean checkUserWinning() {
        PointCount count = new PointCount();
        return this.card.getUser().getPointCount() > this.card.getDealer().getPointCount()
                || count.add(this.card.getUser().getHands()) > this.card.getDealer().getPointCount()
                && this.card.getUser().getPointCount() > count.add(this.card.getDealer().getHands());
    }

    private boolean checkDealerWinning() {
        PointCount count = new PointCount();
        return this.card.getUser().getPointCount() <= this.card.getDealer().getPointCount()
                || count.add(this.card.getUser().getHands()) <= this.card.getDealer().getPointCount()
                && this.card.getUser().getPointCount() <=  count.add(this.card.getDealer().getHands());
    }

}
