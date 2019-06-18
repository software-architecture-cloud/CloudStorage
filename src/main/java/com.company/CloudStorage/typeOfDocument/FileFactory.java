package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.domain.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileFactory {

    private String uploadPat = "/C:/Downloads";

    public FileFactory() {
    }

    public IFile initialize (MultipartFile file) throws IOException {
        if(file.getOriginalFilename().contains(".txt")) {
            return new Txt(file.getBytes());
        }
        if(file.getOriginalFilename().contains(".bmp")){
            return new Bmp(file.getOriginalFilename(), 800, 600);}
        return null;
    }

    public void editFile (Message message) throws FileNotFoundException, UnsupportedEncodingException {
        if(message.getTypeFile().equals("txt")){
            PrintWriter writer = new PrintWriter(uploadPat + "/" + "update"+message.getNameFile(), "UTF-8");
            writer.println(message.getContainsFile());
            writer.close();
            // File file = new File( uploadPath + "/" + "update"+element.getNameFile());
        }
        if(message.getTypeFile().equals("bmp")){
            //Change picture
        }

    }

}
