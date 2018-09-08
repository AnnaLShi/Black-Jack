import CardRules.RulesReader;
import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;
import enumCardTypes.CardSuits;


// get's an idea of how things work
public class Runner {
    public static void main (String []args) {
        Card card = new Card(CardSuits.CLUBS, CardValue.ACE, CardTypes.ACE);
        RulesReader reader = new RulesReader();

        System.out.print(card.getCardType().name());
        // just here for now
    }
}
