package GameSetup.CardBehaviour;

import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;
import enumCardTypes.CardSuits;

public class Card {
        private CardSuits suit;
        private CardValue value;
        private CardTypes cardType;
        private boolean isheld;

        public Card(){
            super();
            this.isheld = false;
        }


        public Card(CardSuits suit, CardValue value, CardTypes type) {
            this.suit = suit;
            this.value = value;
            this.cardType = type;
            this.isheld = false;
        }
        public String getCardSuit() {
            return suit.getSuit();
        }
        public void setCardValue(CardValue value) {
            this.value = value;
        }

        public CardValue getPointValue() {
            return this.value;
        }

        public void setCardType(CardTypes aType) {
            this.cardType = aType;
        }

        public CardTypes getCardType() {
            // ace... Joker
            return this.cardType;
        }
        public boolean isCurrentlyHeld() {
            return this.isheld;
        }
        public void setCurrentlyHeld(boolean isheld) {
            this.isheld = isheld;
        }

}
