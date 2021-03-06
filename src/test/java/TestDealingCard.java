import GameSetup.CardBehaviour.Card;
import GameSetup.CardBehaviour.CardDeck;

import GameSetup.DealCard;
import GameSetup.Players.Dealer;
import GameSetup.Players.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDealingCard {
    @Test
    @DisplayName("Check if dealer and user has cards are unqiue")
    public void checkGivenTwoCards() {
        DealCard deal = new DealCard();
        User user = deal.getUser();
        Dealer dealer = deal.getDealer();

        ini_play(user, dealer, deal);
        assertNotNull(user.getHand());
        assertNotNull(dealer.getHand());
    }
    @Test
    @DisplayName("Check If card exists in any circumstances")
    public void checkCardNotRemoveFromPlay() {
        CardDeck deck= new CardDeck();

        DealCard deal = new DealCard();
        User user = deal.getUser();

        Dealer dealer = new Dealer();
        ini_play(user, dealer, deal);
        ArrayList<Card> test = new ArrayList<Card>();

        test.addAll(deal.getUser().getHand());
        test.addAll(deal.getDealer().getHand());
        test.addAll(deal.deckStatus());

        assertEquals(deck.getCardDeck().size(), test.size());

    }

    private void ini_play(User user, Dealer dealer, DealCard deal) {
        deal = new DealCard();
        user = new User();
        dealer = new Dealer();

        user.addCard(deal.getFirstCard());
        user.addCard(deal.getFirstCard());

        dealer.addCard(deal.getFirstCard());
        dealer.addCard(deal.getFirstCard());

    }

    @Test
    @DisplayName("Check Split after one number")
    public void checkHit() {
       DealCard deal = new DealCard();
       deal.hitUserCalled();
        User user = deal.getUser();

       assertEquals(3, user.getHand().size());
    }
}
