import GameSetup.Screens.FileScreen;
import ReaderTypes.FileReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFileScreen {

    @Test
    @DisplayName("check Invalid File")
    public void checkInvalidFile() {
        FileScreen file = new FileScreen();
        assertTrue(file.isInvalid(new FileReader("back")));
        assertTrue(file.isInvalid(new FileReader("B")));
        assertFalse(file.isInvalid(new FileReader("file1.in")));
    }


    @Test
    @DisplayName("check Valid File")
    public void checkValidFile() {
        FileScreen file = new FileScreen();
        assertTrue(file.isValid(new FileReader("file1.in")));
        assertTrue(file.isValid(new FileReader("file2.in")));
        assertTrue(file.isValid(new FileReader("file3.in")));
    }


    @Test
    @DisplayName("check Back Items")
    public void checkBack() {
        FileScreen file = new FileScreen();
        assertTrue(file.isBack("B"));
        assertTrue(file.isBack("Back"));
    }
}
