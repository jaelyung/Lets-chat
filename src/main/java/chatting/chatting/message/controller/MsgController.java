package chatting.chatting.message.controller;

import chatting.chatting.message.domain.MessageRoom;
import chatting.chatting.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class MsgController {

    private final MessageService messageService;

    @Autowired
    public MsgController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public MessageRoom createRoom(@RequestParam String name) {
        return messageService.createRoom(name);
    }

    @GetMapping
    public List<MessageRoom> findAllRoom() {
        return messageService.findAllRoom();
    }

}
