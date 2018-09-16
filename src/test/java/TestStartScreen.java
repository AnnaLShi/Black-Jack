import GameSetup.Screens.StartScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStartScreen {

    @Test
    @DisplayName("Check for user input file")
    public void checkUserInputFile() {
        StartScreen screen = new StartScreen();
        assertTrue(screen.isFileChose("File"));
        assertTrue(screen.isFileChose("F"));
        assertFalse(screen.isFileChose("Console"));
    }

    @Test
    @DisplayName("Check for user input console")
    public void checkUserInputCommand() {
        StartScreen screen = new StartScreen();
        assertTrue(screen.isConsoleChosen("Console"));
        assertTrue(screen.isConsoleChosen("C"));
        assertFalse(screen.isConsoleChosen("F"));
    }


    @Test
    @DisplayName("Check for user input quit")
    public void checkUserInputQuit() {
        StartScreen screen = new StartScreen();
        assertTrue(screen.isQuitChosen("Q"));
        assertTrue(screen.isQuitChosen("quit"));
        assertFalse(screen.isQuitChosen("F"));
    }

    @Test
    @DisplayName("Invalid Input")
    public void checkInvalidInput(){
        StartScreen screen = new StartScreen();
        assertTrue(screen.isInvalidInput("dsaldjsald"));
    }



}
