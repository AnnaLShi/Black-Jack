package GameSetup.Screens;

import ReaderTypes.DirectoryReader;
import ReaderTypes.FileReader;
import Text_Based_UI.Display;
import Text_Based_UI.IntroScreenUI;
import enumCardTypes.CardCommands;

import java.util.Scanner;

public class FileScreen {


    public void run() {
        System.out.println(IntroScreenUI.file_info);
        Scanner in = new Scanner(System.in);
        String getFileName;
        FileReader reader;
        DirectoryReader directory;

        directory = new DirectoryReader("files");
        System.out.println(directory.printArrayListFiles());


        while (in.hasNext()) {
            getFileName = in.next();
            reader = new FileReader(getFileName);
            if (isBack(getFileName)) {
                Display.returnToMainMenu();
                break;
            }
            if (!isValid(reader)) {
                System.out.println(IntroScreenUI.file_invalid);
                directory = new DirectoryReader("files");
                System.out.println(directory.printArrayListFiles());

            }

            if (isValid(reader)) {
                System.out.print(IntroScreenUI.alt_successful_file(getFileName));
                StartGame game = new StartGame();
                game.run(reader);
            }

        }
    }

    public boolean isInvalid(FileReader reader) {
        return !reader.validateFileType();
    }


    public boolean isValid(FileReader reader) {
        return reader.validateFileType();
    }

    public boolean isBack(String in) {
        return in.toUpperCase().equals(CardCommands.BACK.name()) || in.toUpperCase().equals(CardCommands.BACK.getCommands());
    }
}
