package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.IImageDocument;

public class ResizeImage implements Action{

    private String nameAction = "ResizeImage";

    @Override
    public void doAction(IFile file) {
        IImageDocument fileText = (IImageDocument)file;
        fileText.resize();
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }
}
