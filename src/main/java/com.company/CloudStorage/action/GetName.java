package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetName implements Action {

    private String nameAction = "GetName";

    private String description = "Name of this file :";

    @Override
    public void doAction(IFile file) {
        file.getName();
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
        return file.getName();
    }
}
