package ReaderTypes;

import enumCardTypes.CardCommands;
import enumCardTypes.CardSuits;
import enumCardTypes.CardTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
            // check commands
            for (CardCommands commands: CardCommands.values()) {
                if (this.read.get(i).toUpperCase().equals(commands.getCommands())) {
                    return true;
                }
            }
            for (int j = 0; j < reading.length; j++) {
                // rewrite
                if (!checkValidCommands(Character.toString(this.read.get(i).charAt(j)))) {
                    System.out.println(false);
                    return true;
                }
            }

        }

        return true;
    }


    private boolean checkValidCommands(String command) {
        //System.out.println(command);
        // this is broken for some reason... in file reader so this would need to be checked later
        for (CardSuits suit : CardSuits.values()) {
            if (suit.getSuit().equals(command.toUpperCase()) || suit.name().equals(command.toUpperCase())) {
                return true;
            }
        }

        for (CardTypes types : CardTypes.values()) {
            if (types.getCardType().equals(command.toUpperCase()) || types.name().equals(command.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
    public boolean validateFileType() {
        // this returns if the files read.
        return this.isValidFileType;
    }
    public ArrayList<String> getCommands() {

        if (this.read == null) {
            return null;
        }

        String [] fileCommands = new String[this.read.size()];
        ArrayList<String> commandList = new ArrayList<String>();
        int j = 0;
        for (int i = 0; i < this.read.size(); i++) {
            if (checkCommands(this.read.get(i))) {
                    commandList.add(this.read.get(i).toUpperCase());
            }
            else {
                fileCommands = this.read.get(i).split("\\s+");
                commandList.addAll(Arrays.asList(fileCommands));
            }
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
