import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import enumCardTypes.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDealerAI {
    @Test
    @DisplayName("Test for another card called when there's 16")
    public void checkDealerHits() {
        DealCard deal = new DealCard("test");
        Card c1 = new Card(null, CardValue.ACE, null);
        Card c2 = new Card(null, CardValue.THREE, null);
        Card c3 = new Card(null, CardValue.TWO, null);

        deal.getDealer().addCard(c1);
        deal.getDealer().addCard(c2);
        deal.getDealer().addCard(c3);
        deal.playDealer();
        // this usually works
        assertEquals(4, deal.getDealer().getHand().size());


    }

    @Test
    @DisplayName("Test soft 17")
    public void TestSoft17() {

        DealCard deal = new DealCard("custom");

        Card c1 = new Card(null, CardValue.ACE, null);
        Card c2 = new Card(null, CardValue.FOUR, null);
        Card c3 = new Card(null, CardValue.TWO, null);


        deal.getDealer().addCard(c1);
        deal.getDealer().addCard(c2);
        deal.getDealer().addCard(c3);
        deal.playDealer();

        assertEquals(4, deal.getDealer().getHand().size());
    }
}
