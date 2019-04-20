package com.company.CloudStorage.typeOfDocument;

import javax.persistence.Convert;
import java.util.UUID;

public class Txt implements Document {

    private byte[] symbols;


    private String name;

    public Txt(byte[] symbols) {
        this.symbols = symbols;
    }

    @Override
    public String  getUnicName(String originalFilename) {
        String uuidFile = UUID.randomUUID().toString();
        name = "txt" + uuidFile + "." + originalFilename;
        return name;
    }

    @Override
    public int countSymbols() {
        return symbols.length;
    }

    @Override
    public int countWords() {
        char[] sentence = symbols.toString().toCharArray();
        boolean inWord = false;
        int wordCt = 0;
        for (char c : sentence) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if (!inWord) {
                    wordCt++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return wordCt;
    }

    @Override
    public String makeString() {
        return new String(symbols);
    }

    @Override
    public String getName() {
        return name;
    }


}
