package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.domain.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TextBuilder implements FileBuilder {
    private String uploadPat = "/C:/Downloads";
    @Override
    public IFile initialize(MultipartFile file) throws IOException {
        return new Txt(file.getBytes());
    }

    @Override
    public void editFile(Message message) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(uploadPat + "/" + "update"+message.getNameFile(), "UTF-8");
        writer.println(message.getContainsFile());
        writer.close();
        // File file = new File( uploadPath + "/" + "update"+element.getNameFile());
    }
}
