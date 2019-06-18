package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.ITextDocument;

public class CountSymbols implements Action {

    private String nameAction = "CountSymbols";

    private String description = "Count symbols of this file :";

    @Override
    public void doAction(IFile file) {
        ITextDocument fileText = (ITextDocument)file;
        fileText.countSymbols();
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }

    @Override
    public String getDescriptionAction() {
        return description;
    }

    @Override
    public String resultAction(IFile file) {
        ITextDocument fileText = (ITextDocument)file;
        return String.valueOf(fileText.countSymbols());
    }
}
