package com.mnumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.next();
        ExtensionValidator extensionValidator = ExtensionValidator.of(filepath);
        boolean isTxt = extensionValidator.txtValidator();
        FileReader fileReader = FileReader.of(filepath,isTxt);
        if(isTxt){
            MagicNumbersValidator magicNumbersValidator = MagicNumbersValidator.of(fileReader.readFile());
            magicNumbersValidator.txtValidator();
        } else {
            HexConverter hexConverter = HexConverter.of(fileReader.readFile());
            extensionValidator.validateExtension(hexConverter.getHexRepresentation());
        }



    }
}
