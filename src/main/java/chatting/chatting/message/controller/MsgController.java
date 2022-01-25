package chatting.chatting.message.controller;

import chatting.chatting.message.domain.Message;
import chatting.chatting.message.domain.MessageRoom;
import chatting.chatting.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class MsgController {

//    private final MessageService messageService;
//
//    @Autowired
//    public MsgController(MessageService messageService) {
//        this.messageService = messageService;
//    }
//
//    @PostMapping
//    public MessageRoom createRoom(@RequestParam String name) {
//        return messageService.createRoom(name);
//    }
//
//    @GetMapping
//    public List<MessageRoom> findAllRoom() {
//        return messageService.findAllRoom();
//    }

    private final SimpMessageSendingOperations sendingOperations;

    public MsgController(SimpMessageSendingOperations sendingOperations) {
        this.sendingOperations = sendingOperations;
    }

    @MessageMapping("/comm/message")
    public void message(Message message) {
        if (Message.MessageType.ENTER.equals(message.getMessageType())) {
            message.setMessage(message.getSender() + "님이 입장했습니다.");
        }
        sendingOperations.convertAndSend("/sub/comm/room/" + message.getRoomId(), message);
    }
}
