package com.mnumbers;

import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filepath = "C:\\Users\\Wiktor\\Desktop\\_4273128.jpg";
        Scanner scanner = new Scanner(System.in);
        ExtensionValidator extensionValidator = ExtensionValidator.of(filepath);
        FileReader fileReader = FileReader.of(filepath);
        HexConverter hexConverter = HexConverter.of(fileReader.readFile());
        extensionValidator.validateExtension(hexConverter.getHexRepresentation());

    }
}
