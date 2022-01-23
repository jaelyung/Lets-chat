package chatting.chatting.message.domain;

import chatting.chatting.message.service.MessageService;
import lombok.Builder;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

public class MessageRoom {

    private String roomId;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public MessageRoom(String roomId) {
        this.roomId = roomId;
    }

    public void handleActions(WebSocketSession session, Message message, MessageService messageService) {
        if (message.getMessageType().equals(Message.MessageType.ENTER)) {
            sessions.add(session);
            message.setMessage(message.getSender() + "님이 입장했습니다.");
        }
        sendMessage(message, messageService);
    }

    public <T> void sendMessage(T message, MessageService messageService) {
        sessions.parallelStream().forEach(session -> messageService.sendMessage(session, message));
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Set<WebSocketSession> getSessions() {
        return sessions;
    }

    public void setSessions(Set<WebSocketSession> sessions) {
        this.sessions = sessions;
    }
}
