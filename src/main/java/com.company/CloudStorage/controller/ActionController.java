package com.company.CloudStorage.controller;

import com.company.CloudStorage.action.Action;
import com.company.CloudStorage.domain.Message;
import com.company.CloudStorage.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActionController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/actionfile")
    public String action(@RequestParam String nameAction, Model model, int idMessage
    ) {

        Message message = new Message();
        Iterable<Message> messages = messageRepo.findAll();
        for (Message element: messages
        ) {
            if(element.getId()==idMessage) {
                element.setFile();
                model.addAttribute("messageActionFile", element);
                message = message.clone(element);
            }
        }

        String resultAction;
        model.addAttribute("nameActionFile", nameAction);
        for (Action element : message.getFile().getListAction()
        ) {
            if(element.getNameAction().equals(nameAction)) {
                resultAction = element.resultAction(message.getFile());
                model.addAttribute("descriptionActionFile", element.getDescriptionAction());
                model.addAttribute("resultActionFile", resultAction);
            }
        }

        return "actionfile";
    }

}