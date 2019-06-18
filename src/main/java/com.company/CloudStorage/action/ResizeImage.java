package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.IImageDocument;

public class ResizeImage implements Action{

    private String nameAction = "ResizeImage";

    private String description = "New size of image :";

    @Override
    public void doAction(IFile file) {
        IImageDocument filePicture = (IImageDocument)file;
        filePicture.resize();
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
        IImageDocument filePicture = (IImageDocument)file;
        filePicture.resize();
        return "New size of file : "+ filePicture.getLenght() +":"+filePicture.getWidth();
    }
}
