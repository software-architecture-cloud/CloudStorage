package com.company.CloudStorage.domain;



import com.company.CloudStorage.typeOfDocument.Bmp;
import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.Txt;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String text;
    private String tag;
    private String containsFile;
    private String nameFile;
    private String typeFile;
    @Transient
    private IFile file;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;



    public Message() {
    }


    public Message(String text, String tag, User user, String typeFile) {
        this.author = user;
        this.text = text;
        this.tag = tag;
        this.typeFile = typeFile;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContainsFile() {
        return containsFile;
    }

    public void setContainsFile(String containsFile) {
        this.containsFile = containsFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeFile() {return typeFile; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(containsFile, message.containsFile);
    }

    public IFile getFile() {
        return file;
    }

    public void setFile(IFile file) {
        if(file.getTypeFile().equals("txt"))
            this.file = new Txt(((Txt)file).getSymbols());
        else
            this.file = new Bmp();
    }

    public void setFile() {
        if(typeFile.equals("txt"))
            this.file = new Txt(getContainsFile().getBytes());
        else
            this.file = new Bmp();
    }
}
