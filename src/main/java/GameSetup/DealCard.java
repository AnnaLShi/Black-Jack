package GameSetup;

import GameSetup.CardBehaviour.Card;
import GameSetup.CardBehaviour.CardDeck;
import ReaderTypes.FileReader;

import java.util.ArrayList;
import java.util.Collections;

// this should handle the dealing with two cards
public class DealCard {
    private User user;
    private Dealer dealer;
    private CardDeck deck;

    public DealCard() {
        this.deck = new CardDeck();
        this.user = new User();
        this.dealer = new Dealer();
        Collections.shuffle(this.deck.getCardDeck());
        givePlayersCards();
    }

    // programmed for later
    public DealCard(FileReader file) {

    }

    private void givePlayersCards() {
        this.user.addCard(getFirstCard());
        this.deck.deleteCard(0);

        this.user.addCard(getFirstCard());
        this.deck.deleteCard(0);

        this.dealer.addCard(getFirstCard());
        this.deck.deleteCard(0);
        this.dealer.addCard(getFirstCard());
        this.deck.deleteCard(0);
    }
    public void hitCalled() {
        this.user.addCard(getFirstCard());
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
