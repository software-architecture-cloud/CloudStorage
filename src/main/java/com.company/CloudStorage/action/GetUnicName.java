package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetUnicName implements Action {

    private String nameAction = "GetUnicName";

    private String description = "Unic name of this file :";

    @Override
    public void doAction(IFile file) {
        file.getUnicName(file.getName());
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
        return file.getUnicName(file.getName());
    }
}
