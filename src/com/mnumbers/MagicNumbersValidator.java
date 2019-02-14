package com.mnumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

public class MagicNumbersValidator {

    private static final Map<String, List<String>> MAGIC_NUMBERS = new HashMap<>();

    static {
        MAGIC_NUMBERS.put("jpg",
                          Arrays.asList("^FF D8 FF DB.+",
                                        "^FF D8 FF E0 00 10 4A 46 49 46 00 01.+",
                                        "^FF D8 FF EE.+",
                                        "^FF D8 FF E1 ..... 45 78 69 66 00 00.+"));
        MAGIC_NUMBERS.put("gif", Arrays.asList("^47 49 46 38 37 61.+", "^47 49 46 38 39 61.+"));
    }

    private String extension;
    private String hexRepresentation;

    private MagicNumbersValidator(String extension, String hexRepresentation) {
        this.extension = extension;
        this.hexRepresentation = hexRepresentation;
    }

    public void lieDetector() {
        MAGIC_NUMBERS.get(extension).forEach(str -> {
            if(hexRepresentation.matches(str)) {
                printSuccessResult();
                exit(0);
            }
        });
        printFailResult();
    }

    private void printFailResult() {
        System.out.println("Extension lies! It's not a " + extension + " file!");
    }

    private void printSuccessResult() {
        System.out.println("Type of this file is " + extension);
    }

    static MagicNumbersValidator of(String extension, String hexRepresentation) {
        return new MagicNumbersValidator(extension, hexRepresentation);
    }


}
