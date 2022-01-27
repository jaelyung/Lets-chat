package chatting.chatting.message.controller;

import chatting.chatting.message.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RestController
public class MsgController {

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
