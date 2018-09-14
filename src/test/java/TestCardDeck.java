import CardBehaviour.Card;
import CardBehaviour.CardDeck;
import enumCardTypes.CardRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;




public class TestCardDeck {

    @Test
    @DisplayName("Check for No Joker")
    public void checkNoJoker() {
        // Deck shuffled has no jokers.
        CardDeck cardDeck = new CardDeck(null);
        assertFalse(cardDeck.hasJoker());
    }

    @Test
    @DisplayName("Check for Rules")
    public void checkRules() {
        // this should never be null, as it is. it should just default to default size
        CardDeck deck = new CardDeck(null);
        assertNotNull(deck.getDeckRules());


    }
    @Test
    @DisplayName("Check for Unique Cards")
    public void checkCardsInDeckUnique() {
        // All card in the deck should be Unqiue.
        // override if there is two or more decks being played.
        CardDeck deck = new CardDeck(null);
        HashSet<Card> uniqueCheck = new HashSet<Card>();
        // change name...
        assertEquals(deck.getDeckRules().getRules().get(CardRules.DECK_SIZE) , deck.getSize());
        uniqueCheck.addAll(deck.getCardDeck());
        assertEquals(deck.getDeckRules().getRules().get(CardRules.DECK_SIZE), uniqueCheck.size());
    }

    @Test
    @DisplayName("Check for Assigned Cards to be correct")
    public void checkCardsHaveCorrectValue() {
        // that the cards when first configured that the CardValue and CardType has the same name of enum...
        CardDeck deck = new CardDeck(null);


        for (Card card: deck.getCardDeck()) {
            assertEquals(card.getCardType().name(), card.getPointValue().name());
        }


    }


}
