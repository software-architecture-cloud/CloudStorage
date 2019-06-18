package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetUnicName implements Action {

    private String nameAction = "GetUnicName";

    @Override
    public void doAction(IFile file) {
        file.getUnicName(file.getName());
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }
}
