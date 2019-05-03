package com.company.CloudStorage.typeOfDocument;

public interface IFile {
    public String getUnicName(String originalFilename);

    public String getName();

    public String showContext();

    public String getTypeFile();
}
