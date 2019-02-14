package com.mnumbers;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

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
            exit(0);
        }
    }

    public boolean txtValidator(){
        int startExtensionPosition = filepath.lastIndexOf('.');
        if(startExtensionPosition > 0) {
            String extension = filepath.substring(startExtensionPosition + 1);
            return extension.equals("txt");
        }
        return false;
    }

    static ExtensionValidator of(String filepath){
        return new ExtensionValidator(filepath);
    }

}
