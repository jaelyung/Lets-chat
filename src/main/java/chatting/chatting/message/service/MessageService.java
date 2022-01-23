package chatting.chatting.message.service;

import chatting.chatting.message.domain.MessageRoom;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface MessageService {

    void init();

    List<MessageRoom> findAllRoom();

    MessageRoom findById(String roomId);

    MessageRoom createRoom(String name);

    <T> void sendMessage(WebSocketSession session, T message);
}
