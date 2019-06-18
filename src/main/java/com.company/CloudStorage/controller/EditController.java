package com.company.CloudStorage.controller;

import com.company.CloudStorage.domain.Message;
import com.company.CloudStorage.domain.User;
import com.company.CloudStorage.repos.MessageRepo;
import com.company.CloudStorage.typeOfDocument.FileFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class EditController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;
    private FileFactory fileFactory = new FileFactory();
    private String tempNameFile;


    @GetMapping("/edit")
    public String edit(@RequestParam String editFile, Model model) {
        tempNameFile = editFile;
        Iterable<Message> messages = messageRepo.findAll() ;
        for (Message element:messages
        ) {
            if(element.getContainsFile().equals(editFile))
                model.addAttribute("messageEdit", element);
        }
        return "edit";
    }


    @PostMapping("/edit")
    public String edit2(@RequestParam String editFile, Map<String, Object> model) throws FileNotFoundException, UnsupportedEncodingException {

        Iterable<Message> messages = messageRepo.findAll() ;
        messageRepo.deleteAll();
        for (Message element:messages
        ) {
            if(element.getContainsFile().equals(tempNameFile)) {
                element.setContainsFile(editFile);
                fileFactory.editFile(element);

            }
            messageRepo.save(element);
        }

        return "redirect:/main";
    }

}
