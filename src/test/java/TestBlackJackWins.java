import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import enumCardTypes.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBlackJackWins {
    @Test
    @DisplayName("Check for card combination")
    public void checkforCombination() {
        DealCard dealing = new DealCard("test");
        dealing.getDealer().addCard(new Card(null, CardValue.ACE, null));
        dealing.getDealer().addCard(new Card(null, CardValue.TEN, null));

        dealing.getDealer().removeCard(1);
        dealing.getDealer().addCard(new Card(null, CardValue.JACK, null));

        assertEquals(21, dealing.getDealer().getPointCount());

        dealing.getDealer().removeCard(1);
        dealing.getDealer().addCard(new Card(null, CardValue.QUEEN, null));

        assertEquals(21, dealing.getDealer().getPointCount());

        dealing.getDealer().removeCard(1);
        dealing.getDealer().addCard(new Card(null, CardValue.QUEEN, null));

        assertEquals(21, dealing.getDealer().getPointCount());
    }
    @Test
    @DisplayName("Check for equal Both")
    public void equalsCardCombination() {
        DealCard dealing = new DealCard("test");
        dealing.getDealer().addCard(new Card(null, CardValue.ACE, null));
        dealing.getDealer().addCard(new Card(null, CardValue.JACK, null));

        dealing.getUser().addCard(new Card(null, CardValue.ACE, null));
        dealing.getUser().addCard(new Card(null, CardValue.JACK, null));

        assertTrue(dealing.blackJackUserDealerEquals());

        dealing = new DealCard("test");

        dealing.getDealer().addCard(new Card(null, CardValue.ACE, null));
        dealing.getDealer().addCard(new Card(null, CardValue.QUEEN, null));

        dealing.getUser().addCard(new Card(null, CardValue.ACE, null));
        dealing.getUser().addCard(new Card(null, CardValue.KING, null));

        assertTrue(dealing.blackJackUserDealerEquals());
    }
    @Test
    @DisplayName("Check for equal Both")

    public void equalsCardOneWins() {
        DealCard dealing = new DealCard("test");
        dealing.getDealer().addCard(new Card(null, CardValue.ACE, null));
        dealing.getDealer().addCard(new Card(null, CardValue.JACK, null));

        assertFalse(dealing.checkforBlackJackInUser());


        dealing = new DealCard("test");
        dealing.getDealer().addCard(new Card(null, CardValue.ACE, null));
        dealing.getDealer().addCard(new Card(null, CardValue.JACK, null));
        assertFalse(dealing.checkforBlackJackInUser());

        dealing.getUser().addCard(new Card(null, CardValue.ACE, null));
        dealing.getUser().addCard(new Card(null, CardValue.JACK, null));
        assertTrue(dealing.checkforBlackJackInUser());
    }

}
