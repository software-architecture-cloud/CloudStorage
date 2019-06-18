package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetTypeFile implements Action {

    private String nameAction = "GetTypeFile";

    private String description = "Type of this file :";

    @Override
    public void doAction(IFile file) {
        file.getTypeFile();
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
        return file.getTypeFile();
    }
}
