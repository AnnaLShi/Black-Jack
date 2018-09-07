import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;
import enumCardTypes.EnumSuits;

public class Card {
        private EnumSuits suit;
        private CardValue value;
        private CardTypes cardType;
        private boolean isheld;

        Card(){
            super();
            this.isheld = false;
        }


        Card(EnumSuits suit, CardValue value, CardTypes type) {
            this.suit = suit;
            this.value = value;
            this.cardType = type;
            this.isheld = false;
        }
        public String getCardSuit() {
            return suit.name();
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
