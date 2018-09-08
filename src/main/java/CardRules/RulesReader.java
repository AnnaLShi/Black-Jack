package CardRules;

import enumCardTypes.CardRules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        this.allRules = new ArrayList<String>();
        char [] str;

        String locate = "rules\\" + propName;
        File file = new File(locate);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String rule = br.readLine();

        while (rule != null) {
            str = new char[rule.length()];
            for (int i = 0; i < rule.length(); i++) {
                if (rule.charAt(i) == '#' && rule.charAt(i+1) == '!') {
                    break;
                }
                else {
                    str[i] = rule.charAt(i);
                }
            }
                rule = String.valueOf(str).trim();
            if (rule.length() > 0) {
                this.allRules.add(rule);
            }
            rule = br.readLine();
        }

    }
    // get the size of deck rules extremely similar so clean for code reuse maybe
    private int configSize() {
        String getRule = "";
        StringBuilder getStrInt = new StringBuilder();
        int size;

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


    // this would get all rules that are from the file.

    public String [] getAllRules() {
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
