package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.ITextDocument;

public class CountSymbols implements Action {

    private String nameAction = "CountSymbols";

    @Override
    public void doAction(IFile file) {
        ITextDocument fileText = (ITextDocument)file;
        fileText.countSymbols();
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }
}
