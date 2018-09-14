import CardBehaviour.Card;
import CardBehaviour.CardDeck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestPromptUser {
    // check for invalid input

    @Test
    @DisplayName("Show all possible files")
    public void showAllPossibleFilesTest() {


    }

    @Test
    @DisplayName("show all possible files")
    public void showAllPossibleRulesTest() {

    }
    // modify CardDeckClass
    @Test
    @DisplayName("Check File Input")
    public void checkCardShuffledCorrectly() {
        // that the cards are shuffled without cards
        CardDeck deck = new CardDeck();
        ArrayList<Card> cards = deck.getCardDeck();


    }
}
