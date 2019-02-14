package com.mnumbers;

import java.util.List;

public class HexConverter {

    private List<Integer> fileContent;
    private StringBuilder hexRepresentation = new StringBuilder();


    private HexConverter(List<Integer> fileContent) {
        this.fileContent = fileContent;
    }

    public String getHexRepresentation() {
        for (Integer value : fileContent) {
            hexRepresentation.append(String.format("%02X ", value));
        }
        return hexRepresentation.toString();
    }

    static HexConverter of(List<Integer> fileContent) {
        return new HexConverter(fileContent);
    }

}
