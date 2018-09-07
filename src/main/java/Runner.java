import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;
import enumCardTypes.EnumSuits;

public class Runner {
    public static void main (String []args) {
        Card card = new Card(EnumSuits.CLUBS, CardValue.ACE, CardTypes.ACE);

        System.out.print(card.getCardType().name());
        // just here for now
    }
}
