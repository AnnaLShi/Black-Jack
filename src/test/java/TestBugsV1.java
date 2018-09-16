import GameSetup.CardBehaviour.Card;
import GameSetup.DealCard;
import enumCardTypes.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// this to test for potentical bugs in the program

public class TestBugsV1 {
    @Test
    @DisplayName("Test J, Q, K Values")
    public void TestJQKValues() {
        // WHY? I coded this in a enum?
        assertEquals(10, CardValue.KING.getCardValue()[0]);
        assertEquals(10, CardValue.QUEEN.getCardValue()[0]);
        assertEquals(10, CardValue.JACK.getCardValue()[0]);
    }

    @Test
    @DisplayName("King + Three + Two Aces, Two cards with ")
    public void TestAceValues() {
        DealCard card = new DealCard("test");
        card.getDealer().addCard(new Card(null, CardValue.KING, null));
        card.getDealer().addCard(new Card(null, CardValue.FOUR, null));
        card.getDealer().addCard(new Card(null, CardValue.ACE, null));
        card.getDealer().addCard(new Card(null, CardValue.ACE, null));
        assertEquals(16, card.getDealer().getPointCount());
    }

    @Test
    @DisplayName("Ace + Five + Ace")
    public void TestAceFiveAce() {
        DealCard card = new DealCard("");
        card.getDealer().addCard(new Card(null, CardValue.ACE, null));
        card.getDealer().addCard(new Card(null, CardValue.FIVE, null));
        card.getDealer().addCard(new Card(null, CardValue.ACE, null));

        assertEquals(17, card.getDealer().getPointCount());
    }
    @Test
    @DisplayName("Check if cards are shuffled")
    public void checkShuffle() {
        DealCard cards = new DealCard();
    }





}
