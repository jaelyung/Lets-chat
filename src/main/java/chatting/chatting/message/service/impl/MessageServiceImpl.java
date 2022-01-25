package chatting.chatting.message.service.impl;

import chatting.chatting.message.domain.MessageRoom;
import chatting.chatting.message.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

//    private final MessageMapper messageMapper;
    private final ObjectMapper objectMapper;
    private Map<String, MessageRoom> messageRooms;

//    @Autowired
//    public MessageServiceImpl(MessageMapper messageMapper) {
//        this.messageMapper = messageMapper;
//    }

    @PostConstruct
    @Override
    public void init() {
        messageRooms = new LinkedHashMap<>();
    }

    @Override
    public List<MessageRoom> findAllRoom() {
        return new ArrayList<>(messageRooms.values());
    }

    @Override
    public MessageRoom findById(String roomId) {
        return messageRooms.get(roomId);
    }

    @Override
    public MessageRoom createRoom(String name) {
        String roomId = name;
        MessageRoom msgRoom =  MessageRoom.builder().roomId(roomId).build();
        messageRooms.put(roomId, msgRoom);

        return msgRoom;
    }

    @Override
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
