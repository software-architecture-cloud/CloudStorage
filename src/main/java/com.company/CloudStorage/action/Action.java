package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public interface Action {

    public void doAction(IFile file);

    public String getNameAction();

    public String getDescriptionAction();

    public String resultAction(IFile file);
}
