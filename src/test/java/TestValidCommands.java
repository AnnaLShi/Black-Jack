import ReaderTypes.FileReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// this broke so this is a test

// this is to bug test the valid commands in file reader
public class TestValidCommands {
    @Test
    @DisplayName("Check for Valid Files")
    public void checkValidCommand() {
        FileReader reader1 = new FileReader("file3.in");
        assertNotNull(reader1);
        assertTrue(reader1.validateFileType());

        FileReader reader2 = new FileReader("file4.in");
        assertNotNull(reader2);
        assertTrue(reader2.validateFileType());

        FileReader reader3 = new FileReader("file5.in");
        assertNotNull(reader3);
        assertTrue(reader3.validateFileType());

        // False files type
        FileReader reader4 = new FileReader(null);
        assertNull(reader4);
        assertFalse(reader4.validateFileType());

        FileReader reader5 = new FileReader(".invalid");
        assertNull(reader5);
        assertFalse(reader5.validateFileType());
    }

}
