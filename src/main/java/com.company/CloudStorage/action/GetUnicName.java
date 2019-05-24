package com.company.CloudStorage.action;

import com.company.CloudStorage.typeOfDocument.IFile;

public class GetUnicName implements Action {
    @Override
    public void doAction(IFile file) {
        file.getUnicName(file.getName());
    }
}
