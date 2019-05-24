package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.action.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Txt implements ITextDocument {
    private List<Action> listAction;
    private byte[] symbols;
    private final String type = "txt";

    public Txt(List<Action> listAction, byte[] symbols) {
        listAction = new ArrayList<>(listAction);
        this.symbols = symbols;
    }

    private String name;

    public Txt(byte[] symbols) {
        this.symbols = symbols;
    }

    @Override
    public String  getUnicName(String originalFilename) {
        String uuidFile = UUID.randomUUID().toString();
        name = type + uuidFile + "." + originalFilename;
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
    public String showContext() {
        return new String(symbols);
    }

    @Override
    public String getTypeFile() {
        return type;
    }

    @Override
    public void addAction(Action action) {
        listAction.add(action);
    }

    @Override
    public void deleteAction(Action action) {
        listAction.remove(action);
    }

    @Override
    public List<Action> getListAction() {
        return listAction;
    }

    @Override
    public String getName() {
        return name;
    }


}
