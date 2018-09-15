import GameSetup.CardBehaviour.Card;
import GameSetup.PointCount;
import enumCardTypes.CardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPoints {
    @Test
    @DisplayName("Check Aces + Aces")
    public void checkCorrectAces() {
        Card c1 = new Card(null, CardValue.ACE, null);
        Card c2 = new Card(null, CardValue.ACE, null);
        PointCount count = new PointCount();
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(c1);
        cards.add(c2);

        assertEquals(12, count.add(cards));
    }
    @Test
    @DisplayName("Check Normal Cases")
    public void checkValues(){
        Card c1 = new Card(null, CardValue.JACK, null);
        Card c2 = new Card(null, CardValue.EIGHT, null);
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(c1);
        cards.add(c2);

        PointCount count = new PointCount();
        assertEquals(CardValue.JACK.getCardValue()[0] + CardValue.EIGHT.getCardValue()[0], count.add(cards));

    }

    @Test
    @DisplayName("Check Three Cases")
    public void checkThreeValues() {

        Card c1 = new Card(null, CardValue.FOUR, null);
        Card c2 = new Card(null, CardValue.EIGHT, null);
        Card c3 = new Card(null, CardValue.KING, null);
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);

        PointCount count = new PointCount();
        assertEquals(CardValue.FOUR.getCardValue()[0] + CardValue.EIGHT.getCardValue()[0] + CardValue.KING.getCardValue()[0], count.add(cards));

    }
}
