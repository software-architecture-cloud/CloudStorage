package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.action.Action;
import com.company.CloudStorage.action.CountSymbols;
import com.company.CloudStorage.action.CountWords;
import com.company.CloudStorage.action.ShowContext;

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
        Action countSymbols = new CountSymbols();
        Action countWords = new CountWords();
        Action showContext = new ShowContext();
        listAction = new ArrayList<>();
        listAction.add(countSymbols);
        listAction.add(countWords);
        listAction.add(showContext);
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
        String sentence = new String(symbols);
        int count = 0;

        if(sentence.length() != 0){
            count++;
            for (int i = 0; i < sentence.length(); i++) {
                if(sentence.charAt(i) == ' '){
                    count++;
                }
            }
        }
        return count;
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

    public byte[] getSymbols() {
        return symbols;
    }

    @Override
    public IFile clone(IFile file) {
        return new Txt(((Txt)file).getSymbols());
    }

    @Override
    public String getName() {
        return name;
    }


}
