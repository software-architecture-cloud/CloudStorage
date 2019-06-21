package com.company.CloudStorage.typeOfDocument;

import com.company.CloudStorage.domain.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BmpBuilder implements FileBuilder{
    @Override
    public IFile initialize(MultipartFile file) throws IOException {
        return new Bmp();
    }

    @Override
    public void editFile(Message message) throws FileNotFoundException, UnsupportedEncodingException {
        //Change picture
    }
}
