package siri.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class to write to and read from files
 */
public class SaveFile {
    public static final String FILEPATH = "data/siri.txt";

    public static void createFile() throws IOException {
        File file = new File(FILEPATH);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    /**
     * Clears the file by writing an empty string to it
     *
     * @throws IOException if an input/output operation has failed
     */
    public static void clearFile() throws IOException {
        FileWriter fw = new FileWriter(FILEPATH);
        fw.write("");
        fw.close();
    }

    /**
     * Appends the text specified to the file
     *
     * @param textToAppend text to be appended to the file
     * @throws IOException if an input/output operation has failed
     */
    public static void appendToFile(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH, true); // create a FileWriter in append mode
        fw.write(textToAppend);
        fw.close();
    }

    /**
     * Returns a scanner to read from the file
     *
     * @return scanner
     * @throws FileNotFoundException if file specified in filepath cannot be found
     */
    public static Scanner getScanner() throws FileNotFoundException {
        File f = new File(FILEPATH); // create a File for the given file path
        return new Scanner(f); // create a Scanner using the File as the source
    }
}