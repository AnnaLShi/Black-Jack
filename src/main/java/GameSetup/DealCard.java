package GameSetup;


import GameSetup.CardBehaviour.Card;
import GameSetup.CardBehaviour.CardDeck;
import GameSetup.Players.Dealer;
import GameSetup.Players.PointCount;
import GameSetup.Players.User;
import ReaderTypes.FileReader;
import enumCardTypes.CardValue;

import java.util.ArrayList;
import java.util.Collections;

// this should handle the dealing with two cards
public class DealCard {
    private User user;
    private Dealer dealer;
    private CardDeck deck;
    private PointCount count;
    private int black_jack = 21;

    public DealCard() {
        this.deck = new CardDeck();
        this.user = new User();
        this.dealer = new Dealer();
        this.count = new PointCount();
        Collections.shuffle(this.deck.getCardDeck());
        givePlayersCards();
    }


    // programmed for later
    public DealCard(FileReader file) {
        this.deck = new CardDeck(file.getCommands());
        this.user = new User();
        this.dealer = new Dealer();
        this.count = new PointCount();
        givePlayersCards();
    }

    public boolean blackJackUserDealerEquals() {
        if (this.dealer.getHand().size() == 2 && this.dealer.getPointCount() == black_jack) {
            return true;
        }
        return false;
    }

    public boolean checkforBlackJackInUser() {
        if (this.user.getHand().size() ==2 && this.user.getPointCount() == black_jack) {
            return true;
        }
        return false;
    }

    public DealCard(String testType) {
        // this is for mostly testing purposes
        // this is to see seperate card adding
        this.deck = new CardDeck();
        this.dealer = new Dealer();
        this.user = new User();
        this.count = new PointCount();
        Collections.shuffle(this.deck.getCardDeck());
    }

    public void resetDeckAndHands() {
        this.deck = new CardDeck();
        Collections.shuffle(this.deck.getCardDeck());
        this.user.removeAllCards();
        this.dealer.removeAllCards();
        givePlayersCards();
    }

    public void playDealer() {
         while (this.dealer.getPointCount() <= 16 || checksoft17()) {
            hitDealerCalled();
         }
    }

    private boolean checksoft17() {
        for (Card card: this.dealer.getHand()) {
            if (card.getPointValue().name().equals(CardValue.ACE.name()) && dealer.getPointCount() == 17) {
                return true;
            }
        }
        return false;
    }

    public void givePlayersCards() {
        this.user.addCard(getFirstCard());
        this.deck.deleteCard(0);

        this.user.addCard(getFirstCard());
        this.deck.deleteCard(0);

        this.dealer.addCard(getFirstCard());
        this.deck.deleteCard(0);
        this.dealer.addCard(getFirstCard());
        this.deck.deleteCard(0);
    }
    public void hitUserCalled() {
        this.user.addCard(getFirstCard());
        this.deck.deleteCard(0);
    }

    public void hitDealerCalled() {
        System.out.println(getFirstCard().getCardSuit());
        this.dealer.addCard(getFirstCard());
        this.deck.deleteCard(0);
    }

    public String standCalled() {
        return null;
    }

    public Card getFirstCard() {
        // get the first card at the top of the arraylist
        return this.deck.getCardDeck().get(0);
    }

    public boolean isFromFile() {
        // do this later
        return false;
    }
    public User getUser() {
        return this.user;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public ArrayList<Card> deckStatus() {
        return this.deck.getCardDeck();
    }

}
