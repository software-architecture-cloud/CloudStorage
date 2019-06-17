package com.company.CloudStorage.controller;

import com.company.CloudStorage.action.Action;
import com.company.CloudStorage.domain.Message;
import com.company.CloudStorage.domain.User;
import com.company.CloudStorage.repos.MessageRepo;
import com.company.CloudStorage.typeOfDocument.IFile;
import com.company.CloudStorage.typeOfDocument.ITextDocument;
import com.company.CloudStorage.typeOfDocument.Txt;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    private List<IFile> documents = new ArrayList<IFile>();

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        for (Message element :messages
        ) {
            element.setFile();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            byte[] bytes = file.getBytes();
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            IFile document = new Txt(bytes);
            Message message = new Message(text, tag, user, document.getTypeFile());
            documents.add(document);
            file.transferTo(new File(uploadPath + "/" + document.getUnicName(file.getOriginalFilename())));
            message.setNameFile(document.getName());
            message.setFile(document);
            message.setContainsFile((document).showContext());
            messageRepo.save(message);
//            model.put("actionsfile", message.getFile().getListAction());
            Iterable<Message> messages = messageRepo.findAll();

        }

        Iterable<Message> messages = messageRepo.findAll();
        for (Message element :messages
        ) {
            element.setFile();
        }

        model.put("messages", messages);

        return "main";
    }

    @GetMapping("/main/{nameAction}")
    public String action(
            @PathVariable("nameAction") String nameAction, Message message, Model model
    ) {
        for (Action action:message.getFile().getListAction()
             ) {
            if(action.getNameAction().equals(nameAction))
                model.addAttribute("text",nameAction );
        }

        return "redirect:/main";
    }

}
