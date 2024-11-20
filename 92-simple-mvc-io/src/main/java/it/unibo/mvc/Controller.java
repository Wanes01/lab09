package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEP = File.separator;
    private static final String DEFAULT_FILE_NAME = "output.txt";
    private static final String DEFAULT_FILE_PATH = System.getProperty("user.home") + SEP + DEFAULT_FILE_NAME;
    private File currFile = new File(DEFAULT_FILE_PATH);

    public void setFile(File file) {
        this.currFile = file;
    }

    public File getFile() {
        return this.currFile;
    }

    public String getFilePath() {
        return this.currFile.getPath();
    }

    public void saveOnFile(String text) throws IOException {
        try (final BufferedWriter fw = new BufferedWriter(
                new FileWriter(this.getFilePath()))) {
            fw.write(text);
        }
    }

}