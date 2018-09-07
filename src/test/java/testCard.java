import enumCardTypes.CardTypes;
import enumCardTypes.EnumSuits;
import  org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// spite this into different files so testing can be done in different places

public class testCard {
        @Test
        @DisplayName("Test All")
        void TestAll() {
            //    hasValidCardSuit();
            //    checkAllCardTypes();
        }
        @DisplayName("Test All")
        private void hasValidCardSuit() {
            // test for valid card suit
                int [] test_data = new int[1];

                Card d = new Card("DIAMOND", test_data ,"test");
                Card h = new Card("HEART", test_data ,"test");
                Card c = new Card("CLUBS", test_data ,"test");
                Card s = new Card("SPADES", test_data ,"test");

                checkValidSuit(d);
                checkValidSuit(h);
                checkValidSuit(c);
                checkValidSuit(s);
        }

        private void checkValidSuit(Card card) {
                for (EnumSuits suit: EnumSuits.values()) {
                        if ((card.getCardSuit()).equals(suit.name())) {
                                assertEquals(suit.name(), card.getCardSuit());
                        }
                }
        }

        @DisplayName("Check All Card Types")
        private void checkAllCardTypes() {
                ArrayList<Card> cards = new ArrayList<Card>();
                for (CardTypes types: CardTypes.values()) {
                        Card card = new Card();
                        card.setCardType(types);
                        cards.add(card);
                }

                for (CardTypes types: CardTypes.values()) {
                        for (int i = 0; i < cards.size()-1; i++) {
                                assertEquals(types.name(), cards.get(i).getCardType());
                        }
                }
        }

        private void checkPointValues() {
                ArrayList<Card> cards = new ArrayList<Card>();
                
        }

}
