package com.company.CloudStorage.controller;

import com.company.CloudStorage.domain.Message;
import com.company.CloudStorage.repos.MessageRepo;
import com.company.CloudStorage.typeOfDocument.FileRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class EditController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;
    private FileRealization fileRealization = new FileRealization();
    private String tempNameFile;


    @GetMapping("/edit")
    public String edit(@RequestParam String editFile, Model model) {
        tempNameFile = editFile;
        Iterable<Message> messages = messageRepo.findAll();
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
                fileRealization.editFile(element);

            }
            element.setFile();
            messageRepo.save(element);
        }

        return "redirect:/main";
    }

}
