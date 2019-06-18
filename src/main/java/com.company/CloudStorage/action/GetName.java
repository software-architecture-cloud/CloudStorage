package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetName implements Action {

    private String nameAction = "GetName";

    @Override
    public void doAction(IFile file) {
        file.getName();
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }
}
