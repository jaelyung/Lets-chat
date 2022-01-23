package chatting.chatting.message.controller;

import chatting.chatting.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/chat/newChatRoom")
    public String createNewChatRoom(Model model) {

        model.addAttribute("username", "id1");

        return "chat/newChatRoom";
    }

}
