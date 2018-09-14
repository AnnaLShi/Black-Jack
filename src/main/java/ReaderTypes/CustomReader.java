package ReaderTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomReader {
    private String location;
    private String readerType;

    public CustomReader(String location, String readerType) {
        this.location = location;
        this.readerType = readerType;
    }

     public ArrayList<String> getReadFile() throws IOException {
        ArrayList<String> readItems = new ArrayList<String>();
        char[] str;
        String locate;

        if (this.readerType.toLowerCase().equals("rules")) {
            locate = "rules\\" + this.location;
        } else if (this.readerType.toLowerCase().equals("files")) {
            locate = "files\\" + this.location;
        } else if(this.readerType.toLowerCase().equals("custom")) {
            locate = this.location;
        }
         else {
            throw new IOException("Reader Type is invalid");
        }
        File file = new File(locate);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String getReadItem = br.readLine();

        while (getReadItem != null) {
            str = new char[getReadItem.length()];
            for (int i = 0; i < getReadItem.length(); i++) {
                if (getReadItem.charAt(i) == '#' && getReadItem.charAt(i + 1) == '!') {
                    break;
                } else {
                    str[i] = getReadItem.charAt(i);
                }
            }

            getReadItem = String.valueOf(str).trim();
            if (getReadItem.length() > 0) {
                readItems.add(getReadItem);
            }
            getReadItem = br.readLine();
        }
        return readItems;
    }

    public String getLocation() {
        return this.location;
    }

    public String getReaderType() {
        return this.readerType;
    }
}