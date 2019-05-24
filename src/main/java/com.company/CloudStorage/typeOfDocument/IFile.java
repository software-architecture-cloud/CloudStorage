package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.action.Action;

import java.util.List;

public interface IFile {
    public String getUnicName(String originalFilename);

    public String getName();

    public String showContext();

    public String getTypeFile();

    public void addAction(Action action);

    public void deleteAction(Action action);

    public List<Action> getListAction();
}
