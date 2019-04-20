package com.company.CloudStorage.typeOfDocument;

public interface Document {
    public String getUnicName(String originalName);

    public int countSymbols();

    public int countWords();

    public String makeString();

    public String getName();
}
