import ReaderTypes.CustomReader;
import ReaderTypes.DirectoryReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestFileDisplay {
    // this just tests if the files are on display for the UI
    @Test
    @DisplayName("Check File Display")
    public void checkDisplayFiles() {
        CustomReader getFile = new CustomReader("src\\test\\java\\TestIndividualCard\\TestFileNames","custom");
        String str = null;

        try {
            str = getFile.getReadFile().get(0);
        } catch (IOException e) {
            System.out.println("Yup something went totally went wrong");
            assertNotNull(str);
        }

        String [] temp = str.split("\\s+");
        DirectoryReader reader = new DirectoryReader("files");


        assertArrayEquals(temp, reader.getFilesFromDirectory().toArray());
    }
}
