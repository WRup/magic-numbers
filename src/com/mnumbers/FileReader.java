package com.mnumbers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class FileReader {

    private File file;
    private static final int MAX_MAGIC_NUMBERS_POSITION = 13;
    private boolean isTxt;

    private FileReader(String filepath, boolean isTxt) {
        file = new File(filepath);
        this.isTxt = isTxt;
    }

    public List<Integer> readFile() {
        int currentByte = 0;
        ArrayList<Integer> fileContent = new ArrayList<>();
        try (InputStream is = new FileInputStream(file)) {
            if(isTxt) {
                while ((is.read()) != -1) {
                    fileContent.add(is.read());
                }
            } else {
                for (int i = 0; i < MAX_MAGIC_NUMBERS_POSITION; i++) {
                    if ((currentByte = is.read()) != -1) {
                        fileContent.add(currentByte);
                    }
                }
            }
            return fileContent;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            exit(0);
        } catch (IOException e) {
            System.out.println("Problem with file - cannot be read.");
            exit(0);
        }
        return fileContent;
    }

    static FileReader of(String filepath, boolean isTxt) {
        return new FileReader(filepath, isTxt);
    }
}
