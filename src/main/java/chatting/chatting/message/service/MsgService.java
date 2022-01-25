package chatting.chatting.message.service;

import chatting.chatting.message.domain.MsgRoom;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public interface MsgService {

    List<MsgRoom> findAllRoom();

    MsgRoom findByRoomId(String roomId);

    MsgRoom createMsgRoom(String name);

}
