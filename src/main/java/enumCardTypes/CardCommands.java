package enumCardTypes;

public enum CardCommands {
    DS("DEALER SPLITS"),
    PS("PLAYER SPLITS"),
    SPLITS ("SPLTS"),
    Test ("NULL"),
    PLAYER ("PLAYER"),
    DEALER ("DEALER"),
    FILE ("F"),
    CONSOLE("C"),
    HELP("HELP"),
    HIT("H"),
    STAND("S"),
    BACK("B"),
    YES("Y"),
    NO("N"),
    QUIT("Q");
    ;

    private String commands;

    CardCommands(String commands) {
        this.commands = commands;
    }
    public String getCommands() {
        return this.commands;
    }
}
