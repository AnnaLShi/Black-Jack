
import enumCardTypes.CardCommands;
import enumCardTypes.CardSuits;
import enumCardTypes.CardValue;

public class UserInput {
    private String input;

    UserInput() {
        super();
    }

    public void getUserInput(String input) {
        this.input = input;
    }

    public boolean isValidInput() {
        if (isValidCommand()) {
            return true;
        }
        if (isValidCardSuits()) {
            return true;
        }
        if (isValidCardValue()) {
            return true;
        }

        return false;
    }

    public boolean isValidCommand() {
        for (CardCommands commands : CardCommands.values()) {
            if (commands.name().equals(input.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidCardSuits() {
        for (CardSuits suits : CardSuits.values()) {
            if (suits.name().equals(input.toUpperCase()) || suits.getSuit().equals(input.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidCardValue() {
        // write test case for this later,
        // this I realize have a bit more work put into it.
        for (CardValue value : CardValue.values()) {
            for (int num : value.getCardValue()) {
            }
        }
        return false;
    }


    public String getInput() {
        return this.input;
    }

    public String warningMessage() {
        if (isValidCardSuits() && isValidCommand() && isValidInput()) {
            return null;
        }
        return "Invalid command";
    }

}
