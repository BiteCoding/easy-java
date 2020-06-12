package writer;

import reader.ReaderRakete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private String filePath;

    public Writer(String PATH) {
        this.filePath = PATH;
    }

    public void write(String newText, boolean append) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, append);
            fr.write(newText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void clear() {
        File file = new File(filePath);

        FileWriter fr = null;
        try {
            // Below constructor argument decides whether to append or override
            fr = new FileWriter(filePath, false);
            fr.write("");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete() {
        File file = new File(filePath);
        file.delete();
    }
}
