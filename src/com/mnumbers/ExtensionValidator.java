package com.mnumbers;

import java.util.Arrays;
import java.util.List;

public class ExtensionValidator {

    private String filepath;
    private static final List<String> extensions = Arrays.asList("jpg", "gif", "txt");

    private ExtensionValidator(String filepath){
        this.filepath = filepath;
    }

    public void validateExtension(String hexRepresentation) {
        int startExtensionPosition = filepath.lastIndexOf('.');
        if(startExtensionPosition > 0) {
            String extension = filepath.substring(startExtensionPosition + 1);
            if(extensions.contains(extension)) {
                MagicNumbersValidator magicNumbersValidator = MagicNumbersValidator.of(extension, hexRepresentation);
                magicNumbersValidator.lieDetector();
            }
        } else {
            System.out.println("File with this extension isn't handled.");
        }
    }

    static ExtensionValidator of(String filepath){
        return new ExtensionValidator(filepath);
    }

}
