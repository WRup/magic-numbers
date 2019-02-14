package com.mnumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filepath = "C:\\Users\\Wiktor\\Desktop\\_4273103.txt";
        Scanner scanner = new Scanner(System.in);
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
