import CardRules.RulesReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// More tests would have

public class TestRuleReader {
    @Test
    @DisplayName("Test All")
    public void testAll() {
        checkDefaultSize();
        checkRulesStored();
        checkJoker();
    }

    private void checkDefaultSize() {
        RulesReader rules = new RulesReader();
        rules.deckSize();
        assertEquals(52, rules.deckSize());
    }

    private void checkRulesStored() {
        RulesReader rules = new RulesReader();
        assertNotNull(rules.getAllRules());
    }

    private void checkJoker() {
        RulesReader rules = new RulesReader();
        assertFalse(rules.hasJoker());
    }
}
