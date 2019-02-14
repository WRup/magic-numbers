package com.mnumbers;

import java.util.Arrays;
import java.util.List;

public class ExtensionValidator {

    private String filepath;
    private static final List<String> extensions = Arrays.asList("jpg", "gif", "txt");

    private ExtensionValidator(String filepath){
        this.filepath = filepath;
    }

    static ExtensionValidator of(String filepath){
        return new ExtensionValidator(filepath);
    }

}
