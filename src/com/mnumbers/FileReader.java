package com.mnumbers;

import java.io.File;

public class FileReader {

    private File file;

    private FileReader(String filepath) {
        this.file = new File(filepath);
    }

    static FileReader of(String filepath) {
        return new FileReader(filepath);
    }
}
