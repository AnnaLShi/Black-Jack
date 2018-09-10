import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestConsoleInputType {

    // File input
    @Test
    @DisplayName("Check File Input")
    public void checkFileInput() {
        // this uses all the test files
        String [] check = new String[]{"SK", "HA", "HQ", "CA"};
        checkFile("file1.in", check );

        check = new String[]{"SK", "HQ", "SQ", "C5", "S", "DJ"};
        checkFile("file2.in", check );

        check = new String[]{"S10", "D3", "SQ", "C5", "H", "H5", "H", "sa", "S", "CA", "D2"};
        checkFile("file3.in", check );

        check = new String[]{"Player Splits", "SK", "HK", "CQ", "D9", "D", "H6", "C5", "H", "D3", "S", "H", "D5", "S"};
        checkFile("file4.in", check );

        check = new String[]{"Dealer Splits", "SK", "H9", "C5", "D5", "S", "H7", "CQ", "SA", "SQ", "D2",};
        checkFile("file5.in", check );


    }

    private void checkFile(String fileName, String [] compare) {
        String [] list;
        FileReader reader = new FileReader(fileName);
        String [] tolower = new String[compare.length];
        ArrayList<String> read =  reader.getCommands();
        int i =0;

        for (String com: compare) {
            tolower[i] = com.toUpperCase();
            i++;
        }
        list = read.toArray(new String[read.size()]);
        assertNotNull(list);
        assertArrayEquals(compare, list);
    }
    @Test
    @DisplayName("Check Valid File Input")
    public void checkValidInputType() {
        FileReader fileReader = new FileReader("file1.in");
        assertTrue(fileReader.validateCardType());

        fileReader = new FileReader("invalidFile.in");
        assertFalse(fileReader.validateCardType());
    }

    @Test
    @DisplayName("Check Null ArrayList")
    public void checkEmptyArrayList() {
        FileReader fileReader = new FileReader(".in");
        assertFalse(fileReader.validateCardType());
        assertNull(fileReader.getCommands());
    }



    @Test
    @DisplayName("Check Console Input")
    public void checkConsoleInput() {
            // write later
    }


}
