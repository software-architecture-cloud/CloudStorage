package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.ITextDocument;

public class CountWords implements Action {
    @Override
    public void doAction(IFile file) {
        ITextDocument fileText = (ITextDocument)file;
        fileText.countWords();
    }
}
