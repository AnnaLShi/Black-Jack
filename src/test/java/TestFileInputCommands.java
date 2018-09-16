import GameSetup.CardBehaviour.Card;
import ReaderTypes.CustomReader;
import ReaderTypes.DirectoryReader;
import ReaderTypes.FileReader;
import enumCardTypes.CardCommands;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// this is assuming the other tests are well

public class TestFileInputCommands {
    @Test
    @DisplayName("Check for preconfiguredDeck")
    public void checkPreconfigedDeck(){
        FileReader file = new FileReader("file1.in");
        FileInterpreter fileInterpreter = new FileInterpreter(file);
        for (String commands: file.getCommands()) {
            System.out.println(commands.toUpperCase());
        }
        int i = 0;

        for (Card card: fileInterpreter.getPreconfigedDeck()) {
            for (String commands: file.getCommands()) {
                if ((card.getCardSuit() + card.getCardType().getCardType()).equals(commands)) {
                    i++;
                }
            }
        }
        assertEquals(4, i);
    }

    @Test
    @DisplayName("Check for preconfigured stuff")
    public void checkFileCheckHands() {
        FileInterpreter fileInterpreter = new FileInterpreter(new FileReader("file1.in"));
        CustomReader getFile = new CustomReader("src\\test\\java\\TestIndividualCard\\CardHandSize","custom");
        String str = null;
        try {
            str = getFile.getReadFile().get(0);
        } catch (IOException e) {
            System.out.println("Yup something went totally went wrong");
            assertNotNull(str);
        }
        assertEquals(Integer.parseInt(str), fileInterpreter.getDealCard().getUser().getHand().size());
        assertEquals(Integer.parseInt(str), fileInterpreter.getDealCard().getDealer().getHand().size());

    }
    @Test
    @DisplayName("Check for Hit")
    public void checkHit() {
        FileInterpreter fileInterpreter = new FileInterpreter(new FileReader("File3.in"));

        CustomReader getFile = new CustomReader("src\\test\\java\\TestIndividualCard\\CardHandSize","custom");
        String str = null;
        try {
            str = getFile.getReadFile().get(0);
        } catch (IOException e) {
            System.out.println("Yup something went totally went wrong");
        }
        assertEquals(Integer.parseInt(str), fileInterpreter.getDealCard().getDealer().getHand().size());
        getFile = new CustomReader("src\\test\\java\\TestIndividualCard\\HitSize","custom");
        str = null;
        try {
            str = getFile.getReadFile().get(0);
        } catch (IOException e) {
            System.out.println("Yup something went totally went wrong");
        }

        assertEquals(Integer.parseInt(str), fileInterpreter.getDealCard().getUser().getHand().size());
    }
    @Test
    @DisplayName("Check for Stand")
    public void checkFileStand() {
        FileInterpreter fileInterpreter = new FileInterpreter(new FileReader("File2.in"));

        CustomReader getFile = new CustomReader("src\\test\\java\\TestIndividualCard\\CardHandSize","custom");
        String str = null;
        try {
            str = getFile.getReadFile().get(0);
        } catch (IOException e) {
            System.out.println("Yup something went totally went wrong");
        }
        assertEquals(Integer.parseInt(str), fileInterpreter.getDealCard().getUser().getHand().size());
        getFile = new CustomReader("src\\test\\java\\TestIndividualCard\\HitSize","custom");
        str = null;
        try {
            str = getFile.getReadFile().get(0);
        } catch (IOException e) {
            System.out.println("Yup something went totally went wrong");
        }
        assertEquals(Integer.parseInt(str), fileInterpreter.getDealCard().getDealer().getHand().size());

    }
}
