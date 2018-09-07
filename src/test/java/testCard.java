import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;
import enumCardTypes.EnumSuits;
import  org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Fix  this to

public class testCard {
        @Test
        @DisplayName("Test All")
        void TestAll() {
                checkAllCardTypes();
                checkPointValues();
        }

        @DisplayName("Check All Card Types")
        private void checkAllCardTypes() {
                ArrayList<Card> cards = new ArrayList<Card>();
                int count_correct = 0;
                int expected_correct = 13;

                for (CardTypes types: CardTypes.values()) {
                        Card card = new Card();
                        card.setCardType(types);
                        cards.add(card);
                }

                for (CardTypes types: CardTypes.values()) {
                        for (int i = 0; i < cards.size()-1; i++) {
                                if  (types.name().equals(cards.get(i).getCardType().name())) {
                                        assertEquals(types.name(), cards.get(i).getCardType().name());
                                        count_correct++;
                                }
                        }
                }
                assertEquals(expected_correct , count_correct);
        }

        private void checkPointValues() {
                ArrayList<Card> cards = new ArrayList<Card>();
                int count_correct = 0;
                int expected_correct = 13;
                for (CardValue value: CardValue.values()) {
                        Card card = new Card();
                        card.setCardValue(value);
                        cards.add(card);
                }


                for (CardValue value: CardValue.values()) {
                        for (int i = 0; i < cards.size()-1; ++i) {
                                if (value.name().equals(cards.get(i).getPointValue().name())) {
                                        assertEquals(value.getCardValue(), cards.get(i).getPointValue().getCardValue());
                                        count_correct++;
                                }
                        }
                }
                assertEquals(expected_correct , count_correct);

                // log this out or something
        }



        private void checkSameName(CardTypes type, CardValue value) {
                assertEquals(type.name(), value.name()); // this might be moved to test when the cards are created.
        }

}
