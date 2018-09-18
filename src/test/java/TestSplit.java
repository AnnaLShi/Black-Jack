import GameSetup.CardBehaviour.Card;
import GameSetup.CardBehaviour.CardDeck;
import GameSetup.DealCard;
import GameSetup.Players.Dealer;
import GameSetup.User;
import enumCardTypes.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSplit {
    @Test
    @DisplayName("Can split.")
    public void splitable() {
        Card card1 = new Card(null, CardValue.TEN , null);
        Card card2 = new Card(null, CardValue.TEN , null);

        DealCard dealCard = new DealCard("customCards");
        dealCard.getUser().addCard(card1);
        dealCard.getUser().addCard(card2);
        assertTrue(dealCard.isUserSplitable());
    }

    @Test
    @DisplayName("User split test")
    public void cardSplited() {
        Card card1 = new Card(null, CardValue.TWO , null);
        Card card2 = new Card(null, CardValue.TWO , null);
        User user = new User();
        DealCard dealCard = new DealCard("customCards");
        dealCard.getUser().addCard(card1);
        dealCard.getUser().addCard(card2);
        dealCard.split();


        assertEquals(2 , dealCard.getUser().getHand().size());
    }

    @Test
    @DisplayName("Dealer split test")
    public void dealerSplited() {
        Card card1 = new Card(null, CardValue.ACE , null);
        Card card2 = new Card(null, CardValue.ACE , null);
        DealCard dealCard = new DealCard("customCards");

        dealCard.getDealer().addCard(card1);
        dealCard.getDealer().addCard(card2);
        dealCard.split();

        assertEquals(2 , dealCard.getDealer().getHand().size());

        // modify ArrayList<Arraylist<String>>;
    }
}
