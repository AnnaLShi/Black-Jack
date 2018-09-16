package Text_Based_UI;

// these just returns strings of introdutions to Screens
public final class IntroScreenUI {
    // Main menu
    public final static String introToGame = "Welcome to black jack, please enter either f (file), c (console) or h (help). \n";
    public final static String introToGame_Hello = "Hello There!, please enter either f (file), c (console) or h (help)\n";

    // selected
    public final static String help_Selected = "Help \n";
    public final static String file_selected = "File \n";
    public final static String console_selected = "Console \n";

    // help screen
    public final static String help_info = "The help screen has been selected \n" + "Commands: \n" + "f (or file) - this would load from file \n"
            + "c ( or console)- this would play the the game normally \n" + "e (or exit) - this would exit the game \n" + "b (or back) - this would go back to the main menu";

    // loading files
    public final static String file_info = "This is the menu for loading and showing the files from 'Black Jack/files', choose wisely... \n" +
            "Note: There is nothing on this for now as this is just adding a UI to be able to link up with the FileReader Class";
    public final static String file_invalid = "File Invalid! Please check for number or if file has moved \n";
    public final static String file_num_invalid = "Invalid Number, please enter another number \n";
    public final static String successful_file = "File sucessfully loaded! \n";

    public final static String alt_successful_file(final String str) {
        return  "You have choosen wisely..." + str + " has been loaded\n";
    }

    // playing game
    public final static String go_to_game = "Heading over to a new game \n";

    // Leaving
    public final static String closed_application = "Bye Bye \n";

    // Back
    public final static String Back_To_Main_Menu = "Main Menu \n";

    // In development messages
    public final static String work_on_this = "... I can't belive, this can't be... \n";

    public final static String invalid_message(String str) {
        return "Warning this is an Invalid Console Command: " + str;
    }
}
