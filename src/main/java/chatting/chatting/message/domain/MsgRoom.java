package chatting.chatting.message.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
public class MsgRoom {

    private Long id;
    private String roomId;

    public MsgRoom() {
    }

    public MsgRoom(Long id, String roomId) {
        this.id = id;
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
