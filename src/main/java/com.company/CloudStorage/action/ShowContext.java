package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class ShowContext implements Action {

    private String nameAction = "ShowContext";

    @Override
    public void doAction(IFile file) {
        file.showContext();
    }

    @Override
    public String getNameAction() {
        return nameAction;
    }
}
