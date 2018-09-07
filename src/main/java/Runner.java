import enumCardTypes.CardTypes;
import enumCardTypes.CardValue;
import enumCardTypes.EnumSuits;



// get's an idea of how things work
public class Runner {
    public static void main (String []args) {
        Card card = new Card(EnumSuits.CLUBS, CardValue.ACE, CardTypes.ACE);

<<<<<<< HEAD

=======
        System.out.print(card.getCardType().name());
>>>>>>> 9aa97420bf14d9dce379180566fdadb73794bd0c
        // just here for now
    }
}
