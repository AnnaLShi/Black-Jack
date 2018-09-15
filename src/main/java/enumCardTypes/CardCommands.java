package enumCardTypes;

public enum CardCommands {
    SPLITS ("SPLITS"),
    Test ("NULL"),
    PLAYER ("PLAYER"),
    DEALER ("DEALER"),
    FILE ("F"),
    CONSOLE("C"),
    HELP("H"),
    HIT("H"),
    STAND("S"),
    BACK("B");
    ;

    private String commands;

    CardCommands(String commands) {
        this.commands = commands;
    }
    public String getCommands() {
        return this.commands;
    }
}
