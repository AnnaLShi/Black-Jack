package ReaderTypes;

import enumCardTypes.CardRules;

import java.io.IOException;
import java.util.ArrayList;

// a method that reads the properties and gets the rules from it... ma
public class RulesReader {

    // rules that are configured
    private ArrayList<String> allRules;
    private int size;
    private boolean isJokerInSet;


    // non-default Rules
    public RulesReader(String propName){
        // configures the rules
       try {
           readRules(propName);
       } catch (IOException e) {
           System.out.println("WARNING, RULES ARE NOT IN CORRECT FOLDER OR HAS BEEN INCORRECTLY NAMED");
       }
       // size
        this.size = configSize();
       this.isJokerInSet = checkJoker();

    }


    // default Rules
    public RulesReader() {
        // configures the rules
        try {
            readRules("DefaultRules.rule");
        } catch (IOException e) {
            System.out.println("WARNING, RULES ARE NOT IN CORRECT FOLDER OR HAS BEEN INCORRECTLY NAMED");
        }
        // size
        this.size = configSize();

    }


    private void readRules(String propName) throws IOException{
        CustomReader reader = new CustomReader(propName, "rules");
        this.allRules = reader.getReadFile();

    }
    // get the size of deck rules extremely similar so clean for code reuse maybe
    private int configSize() {
        String getRule = "";
        StringBuilder getStrInt = new StringBuilder();
        int size;

        if (allRules == null) {
            // This error means that the rules aren't read
            return -1;
        }
        for (String str: allRules) {
            if (str.contains(CardRules.DECK_SIZE.name())) {
                getRule = str;
                break;
            }
        }

        for (int i = getRule.length() - 1; i > 0; i--) {
            if (Character.isDigit(getRule.charAt(i))) {
                getStrInt.append(getRule.charAt(i));
            }
        }

        getStrInt.reverse();

        if (getStrInt.length() == 0) {
            return -1;
        }
        return Integer.parseInt(getStrInt.toString());
    }



    public boolean checkJoker() {
       String getRule = "";
       StringBuilder getStrInt = new StringBuilder();
        String booleanCheck;

        if (this.allRules == null) {
            return false;
        }

       for (String str: allRules) {
           if (str.contains(CardRules.HAS_JOKER.name())) {
               getRule = str;
               break;
           }
       }

       for (int i = getRule.length() - 1; i > 0; i--) {
               if (getRule.charAt(i) == ' ') {
                   break;
               }
                getStrInt.append(getRule.charAt(i));

       }

       booleanCheck = getStrInt.reverse().toString();
       if (booleanCheck.toLowerCase().equals("true")) {
           return true;
       }
       else if (booleanCheck.toLowerCase().equals("false")) {
           return false;
       }

       return false;

    }

    public String [] getAllRules() {
        if (allRules == null) {
            return null;
        }
        return allRules.toArray(new String[allRules.size()]);
    }



    public int deckSize() {
        return this.size;
    }

    public boolean hasJoker() {
        return this.isJokerInSet;
    }

    public boolean initializationCheck() {
        return false;
    }

}
