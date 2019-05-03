package com.company.CloudStorage.typeOfDocument;

import java.util.UUID;

public class Bmp implements IImageDocument {

    private final String type = "bmp";
    private String name;
    private int width;
    private int lenght;

    public Bmp(String name, int width, int lenght) {
        this.name = name;
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public void resize(int width, int lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public String getUnicName(String originalFilename) {
        String uuidFile = UUID.randomUUID().toString();
        name = type + uuidFile + "." + originalFilename;
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String showContext() {
        return "This is picture: " + name + "with size: " + lenght +"x" + width;
    }

    @Override
    public String getTypeFile() {
        return type;
    }
}
