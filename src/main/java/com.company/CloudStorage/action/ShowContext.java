package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class ShowContext implements Action {

    private String nameAction = "ShowContext";

    private String description = "Context of this file : ";

    @Override
    public void doAction(IFile file) {
        file.showContext();
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
        return file.showContext();
    }
}
