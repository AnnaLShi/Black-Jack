package ReaderTypes;

import java.io.File;
import java.util.ArrayList;

public class DirectoryReader {
    private ArrayList<String> fileslist;
    public DirectoryReader(String location) {
        // format Black \ Jack/....
        this.fileslist = new ArrayList<String>();
        File direct = new File(location);
        File[] list = direct.listFiles();
        for (File file: list) {
            if (file.isFile()) {
                this.fileslist.add(file.getName());
            }
        }
    }
    public ArrayList<String> getFilesFromDirectory() {
        return this.fileslist;
    }

    // change this to a String
    public String printArrayListFiles() {
        String newFileList = "";
        for (String list: this.fileslist) {
            newFileList += list + "\n";
        }
        return newFileList;
    }
}
