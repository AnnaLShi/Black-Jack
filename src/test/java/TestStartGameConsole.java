import GameSetup.Screens.StartGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStartGameConsole {

    @Test
    @DisplayName("Check for No")
    public void checkForNoResponse() {
        StartGame game = new StartGame();
        assertTrue(game.checkNo("N"));
        assertTrue(game.checkNo("No"));
        assertTrue(game.checkNo("NO"));
        assertFalse(game.checkNo("ksdal"));
    }

    @Test
    @DisplayName("Check for Yes")
    public void checkforYesResponse() {
        StartGame game = new StartGame();
        assertTrue(game.checkYes("Yes"));
        assertTrue(game.checkYes("y"));
        assertFalse(game.checkYes("7894"));
    }


    @Test
    @DisplayName("Check for invalid input")
    public void checkForInvaildResponse(){
        StartGame game = new StartGame();
        assertTrue(game.invalidInput("asdfsaf"));
    }
}
