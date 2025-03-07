package siri.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveFile {
    public static final String FILEPATH = "data/siri.txt";

    public static void clearFile() throws IOException {
        FileWriter fw = new FileWriter(FILEPATH);
        fw.write("");
        fw.close();
    }

    public static void appendToFile(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH, true); // create a FileWriter in append mode
        fw.write(textToAppend);
        fw.close();
    }

    public static Scanner getScanner() throws FileNotFoundException {
        File f = new File(FILEPATH); // create a File for the given file path
        return new Scanner(f); // create a Scanner using the File as the source
    }
}