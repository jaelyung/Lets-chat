package chatting.chatting.message.service.impl;

import chatting.chatting.message.domain.MsgRoom;
import chatting.chatting.message.service.MsgService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class MsgServiceImpl implements MsgService {

    private Map<String, MsgRoom> msgRoomMap;

    @PostConstruct
    private void init() {
        msgRoomMap = new LinkedHashMap<>();
    }

    @Override
    public List<MsgRoom> findAllRoom() {
        List<MsgRoom> msgRooms = new ArrayList<>(msgRoomMap.values());
        Collections.reverse(msgRooms);
        return msgRooms;
    }

    @Override
    public MsgRoom findByRoomId(String roomId) {
        return msgRoomMap.get(roomId);
    }

    @Override
    public MsgRoom createMsgRoom(String name) {
        MsgRoom room = MsgRoom.builder().roomId(name).build();
        msgRoomMap.put(room.getRoomId(), room);
        return room;
    }
}
