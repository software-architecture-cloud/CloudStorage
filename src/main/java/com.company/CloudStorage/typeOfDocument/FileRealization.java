package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.domain.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileRealization {

    private FileBuilder fileBuilder;

    public FileRealization(FileBuilder fileBuilder) {
        this.fileBuilder = fileBuilder;
    }

    public FileRealization() {
    }

    public void setFileBuilder(FileBuilder fileBuilder) {
        this.fileBuilder = fileBuilder;
    }

    public IFile initialize (MultipartFile file) throws IOException {
        return fileBuilder.initialize(file);
    }

    public void editFile (Message message) throws FileNotFoundException, UnsupportedEncodingException {
        fileBuilder.editFile(message);
    }

}
