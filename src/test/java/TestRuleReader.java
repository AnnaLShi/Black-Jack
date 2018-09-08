import CardRules.RulesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// More tests would have be created to increase functinality
@DisplayName("Test Rule Text Configuration")
public class TestRuleReader {

    @Test
    @DisplayName("Check Default Size")
    public void checkDefaultSize() {
        // check the size of the default size
        RulesReader rulesReader = new RulesReader();
        rulesReader.deckSize();

        assertEquals(52, rulesReader.deckSize());
    }

    @Test
    @DisplayName("Check Rules Stored")
    public void checkRulesStored() {
        // this tests if the rules have been initialized and stored.
        RulesReader rules = new RulesReader();
        assertNotNull(rules.getAllRules());
    }

    @Test
    @DisplayName("Check Default Rules")
    public void checkDefaultJoker() {
        RulesReader rules = new RulesReader();
        assertFalse(rules.hasJoker());
    }


    @Test
    @DisplayName("Check No Rules")
    public void checkNoRules() {
        // this check should check in non existance rule directory.
        // make sure there is something written to check for valid rules.
        RulesReader rulesReader = new RulesReader("dont\\exist");
        assertNull(rulesReader);
        assertEquals(0, rulesReader.deckSize());
        assertEquals(false, rulesReader.hasJoker());
    }

    @Test
    @DisplayName("Non-Default Size")
    public void nonDefaultSize() {
        RulesReader rulesReader = new RulesReader("TestRules\\testRules1.rules");
        assertEquals(36, rulesReader.deckSize());
    }
    @Test
    @DisplayName("Check for True Joker")
    private void checkforTrueJoker() {
        RulesReader rulesReader = new RulesReader("TestRules\\testRules1.rules");
        assertTrue(rulesReader.hasJoker());
    }

    @Test
    @DisplayName("Check for Valid Settings")
    private void checkForValidSettings() {

    }

    private void initializationCheck() {
        // This should check if the initialization looks good.


    }

}
