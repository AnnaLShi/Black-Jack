import java.util.ArrayList;

// I'll have to move this elsewhere
public class FileReader {
    private ArrayList<String> read;
    private boolean isValidCardType;

    public FileReader(String fileName)  {
        this.read = commands(fileName);
        this.isValidCardType = checkValidCardType(read);
    }

    private ArrayList<String> commands(String fileName){
        return null;
    }

    private boolean checkValidCardType(ArrayList<String> read) {
        return false;
    }

    public boolean validateCardType() {
        // this returns if the files read.
        return isValidCardType;
    }
    public ArrayList<String> getCommands() {
        return null;
    }


}
