package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.action.Action;
import com.company.CloudStorage.action.ResizeImage;
import com.company.CloudStorage.action.ShowContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bmp implements IImageDocument {

    private List<Action> listAction;
    private final String type = "bmp";
    private String name;
    private int width;
    private int lenght;
    private int newWidth=1000;
    private int newlenght=700;

    public Bmp() {
        this.width = 1200;
        this.lenght = 800;
        Action resizeImage = new ResizeImage();
        Action showContext = new ShowContext();
        listAction = new ArrayList<>();
        listAction.add(resizeImage);
        listAction.add(showContext);
    }

    public Bmp(int width, int lenght) {
        this.width = width;
        this.lenght = lenght;
        Action resizeImage = new ResizeImage();
        Action showContext = new ShowContext();
        listAction = new ArrayList<>();
        listAction.add(resizeImage);
        listAction.add(showContext);
    }

    public Bmp(List<Action> listAction, int width, int lenght) {
        listAction = new ArrayList<>(listAction);
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public void resize() {
        this.width = newWidth;
        this.lenght = newlenght;
    }

    @Override
    public void setNewSize(int width, int lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public String getUnicName(String originalFilename) {
        name = originalFilename;
        String uuidFile = UUID.randomUUID().toString();
        name = type + uuidFile + "." + originalFilename;
        return name;
    }

    @Override
    public void addAction(Action action) {
        listAction.add(action);
    }

    @Override
    public void deleteAction(Action action) {
        listAction.remove(action);
    }

    @Override
    public List<Action> getListAction() {
        return listAction;
    }

    @Override
    public IFile clone(IFile file) {
        return new Bmp(((Bmp)file).getLenght(), ((Bmp)file).getWidth());
    }

    public int getWidth() {
        return width;
    }

    public int getLenght() {
        return lenght;
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
