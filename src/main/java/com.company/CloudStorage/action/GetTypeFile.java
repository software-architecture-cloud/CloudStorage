package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetTypeFile implements Action {
    @Override
    public void doAction(IFile file) {
        file.getTypeFile();
    }
}
