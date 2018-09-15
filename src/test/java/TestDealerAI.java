import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import GameSetup.Dealer;
import enumCardTypes.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDealerAI {
    @Test
    @DisplayName("Test for another card called when there's 16")
    public void checkDealerHits() {
        Dealer deal = new Dealer();
        Card c1 = new Card(null, CardValue.ACE, null);
        Card c2 = new Card(null, CardValue.THREE, null);
        Card c3 = new Card(null, CardValue.TWO, null);

        deal.addCard(c1);
        deal.addCard(c2);
        deal.addCard(c3);

        deal.play();

        assertEquals(4, deal.getDealerHand().size());

    }

    @Test
    @DisplayName("Test soft 17")
    public void TestSoft17() {
        Dealer deal = new Dealer();
        Card c1 = new Card(null, CardValue.ACE, null);
        Card c2 = new Card(null, CardValue.FOUR, null);
        Card c3 = new Card(null, CardValue.TWO, null);

        deal.addCard(c1);
        deal.addCard(c2);
        deal.addCard(c3);
        deal.play();


             assertEquals(4, deal.getDealerHand().size());

    }
}
