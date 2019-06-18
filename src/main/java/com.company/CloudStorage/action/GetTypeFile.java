package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetTypeFile implements Action {

    private String nameAction = "GetTypeFile";

    @Override
    public void doAction(IFile file) {
        file.getTypeFile();
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }
}
