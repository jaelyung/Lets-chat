package chatting.chatting.handler;

import chatting.chatting.message.domain.Message;
import chatting.chatting.message.domain.MessageRoom;
import chatting.chatting.message.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class ChatHandler extends TextWebSocketHandler {

    private final MessageService messageService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ChatHandler(MessageService messageService, ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        log.info("payload : {}", payload);

        Message msg = objectMapper.readValue(payload, Message.class);
        MessageRoom messageRoom = messageService.findById(msg.getRoomId());
        messageRoom.handleActions(session, msg, messageService);

    }

    /* Client 접속시 호출되는 메서드 */
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        list.add(session);
//    }
//
//    /* Client 접속 해제시 호출되는 메서드 */
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//
//        list.remove(session);
//    }
}
