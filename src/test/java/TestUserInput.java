import ReaderTypes.FileReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// this a security thing

public class TestUserInput {
    @Test
    @DisplayName("Check that java has read the method correctly")
    public void CheckSantizationRead(){
        UserInput input = new UserInput();
        // probably put this in a enum.
        String userInput = "? > < amp { } , \\ + - , . ! ^";
        input.getUserInput(userInput);
        assertFalse(input.isValidInput());

        userInput = "";
        input.getUserInput(userInput);
        assertTrue(input.isValidInput());

        userInput = "S10";
        input.getUserInput(userInput);
        assertTrue(input.isValidInput());

        userInput = "SJ D10";
        input.getUserInput(userInput);
        assertTrue(input.isValidInput());
    }

    @Test
    @DisplayName("Check For valid")
    public void checkallCommands() {
        // this using the pre-assignment assignment to test valid tests
        UserInput input = new UserInput();
        FileReader file = new FileReader("file1.in");
        ArrayList<String> getFile = file.getCommands();

        for (String str: getFile) {
            input.getUserInput(str);
            assertTrue(input.isValidInput());
        }

        file = new FileReader("file2.in");
        getFile = file.getCommands();

        for (String str: getFile) {
            input.getUserInput(str);
            assertTrue(input.isValidInput());
        }

        file = new FileReader("file3.in");
        getFile = file.getCommands();

        for (String str: getFile) {
            input.getUserInput(str);
            assertTrue(input.isValidInput());
        }

        file = new FileReader("file4.in");
        getFile = file.getCommands();

        for (String str: getFile) {
            input.getUserInput(str);
            assertTrue(input.isValidInput());
        }

        file = new FileReader("file5.in");
        getFile = file.getCommands();

        for (String str: getFile) {
            input.getUserInput(str);
            assertTrue(input.isValidInput());
        }


    }

    @Test
    @DisplayName("Check For invalid Input")
    public void checkInvalidInput() {
        // checks for warning on the opening screen. Other test cases should be written for otger screens.
        UserInput input = new UserInput();
        String message = "YUP@ &*";
        input.getUserInput(message);
        assertNotNull(input.warningMessage());

        String valid = "c";
        input.getUserInput(message);
        assertNull(input.warningMessage());
    }

    @Test
    @DisplayName("Check that java has read the method correctly")
    public void stuff() {

    }


    // use both Scanner and bufferString methods for implemtation
}
