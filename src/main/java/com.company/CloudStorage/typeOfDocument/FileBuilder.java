package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.domain.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface FileBuilder {
    IFile initialize (MultipartFile file) throws IOException;
    void editFile (Message message) throws FileNotFoundException, UnsupportedEncodingException;
}
