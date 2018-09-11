package ReaderTypes;

import enumCardTypes.CardCommands;
import enumCardTypes.CardSuits;
import enumCardTypes.CardTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// I'll have to move this elsewhere
public class FileReader {
    private ArrayList<String> read;
    private boolean isValidFileType;
    private String [] fileCommands;

    public FileReader(String fileName)  {
        CustomReader customReader = new CustomReader(fileName, "files");
        try {
            this.read = customReader.getReadFile();
        }
        catch (IOException e) {
            System.out.print("WARNING FILE IS MISSPELLED OR MISSING");
            this.isValidFileType = false;
        }
        this.isValidFileType = checkValidRuleType();
    }

    private boolean checkValidRuleType() {
        // this would test if the files  specified in the deck
        String [] reading;

        if (this.read == null) {
            return false;
        }
        for (int i = 0; i < this.read.size(); i++) {
            String file = this.read.get(i);
            reading = file.split("\\s+");
            for (int j = 0; j < reading.length; j++) {

                if (!checkValidCommands(reading[j])) {
                    for (int k = 0; k < reading[j].length(); k++) {
                        if (!checkValidCommands(Character.toString(reading[j].charAt(k)))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean checkValidCommands(String command) {
        for (CardSuits suit: CardSuits.values()) {
            if (suit.getGetSuit().equals(command) || suit.name().equals(command.toUpperCase())) {
                return true;
            }
        }

        for (CardTypes types: CardTypes.values()) {
            if (types.getCardType().equals(command) || types.name().equals(command.toUpperCase())) {
                return true;
            }
        }
        for (CardCommands comands: CardCommands.values()) {
            if (comands.name().toLowerCase().equals(command.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public boolean validateFileType() {
        // this returns if the files read.
        return isValidFileType;
    }
    public ArrayList<String> getCommands() {

        if (this.read == null) {
            return null;
        }

        String [] fileCommands = new String[this.read.size()];
        ArrayList<String> commandList = new ArrayList<String>();
        int j = 0;
        for (int i = 0; i < this.read.size(); i++) {
            System.out.print(j++);
            System.out.print( this.read.get(i));
            if (checkCommands(this.read.get(i))) {
                    commandList.add(this.read.get(i).toUpperCase());
            }
            else {
                fileCommands = this.read.get(i).split("\\s+");
                commandList.addAll(Arrays.asList(fileCommands));
            }
        }

       for (String str: commandList) {
            System.out.println(str);
        }
        return commandList;
    }

    private boolean checkCommands(String compare) {
        // split here
        String [] temp = compare.split("\\s+");
        
        for (CardCommands commands : CardCommands.values()) {
            for (String com: temp) {
                if (commands.name().toUpperCase().equals(com.toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }
}
