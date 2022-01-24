package chatting.chatting.message.service;

import chatting.chatting.message.domain.MessageRoom;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public interface MessageService {

    void init();

    List<MessageRoom> findAllRoom();

    MessageRoom findById(String roomId);

    MessageRoom createRoom(String name);

    <T> void sendMessage(WebSocketSession session, T message);
}
