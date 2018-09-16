package GameSetup.Screens;

import Text_Based_UI.GameMessages;
import Text_Based_UI.IntroScreenUI;
import enumCardTypes.CardCommands;

public class StartScreen {

    public void showStartIntroduction() {
        System.out.println(IntroScreenUI.introToGame);
    }

    public boolean isFileChose(String in) {
        return  in.toUpperCase().equals(CardCommands.FILE.getCommands()) || in.toUpperCase().equals(CardCommands.FILE.name());
    }
    public boolean isConsoleChosen(String in) {
        return in.toUpperCase().equals(CardCommands.CONSOLE.getCommands()) || in.toUpperCase().equals(CardCommands.CONSOLE.name());
    }

    public boolean isQuitChosen(String in) {
        return in.toUpperCase().equals(CardCommands.QUIT.getCommands()) || in.toUpperCase().equals(CardCommands.QUIT.name());
    }

    public boolean isHelpChosen(String in) {
        if (in.toUpperCase().equals(CardCommands.HELP.name()) || in.toUpperCase().equals("H")) {
            System.out.println(IntroScreenUI.help_info);
            return true;
        }
        return false;
    }

    public boolean isInvalidInput(String in) {
        System.out.println(IntroScreenUI.invalid_message(in));
        System.out.println(GameMessages.outline);
        return true;
    }
}
