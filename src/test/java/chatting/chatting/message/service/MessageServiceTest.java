package chatting.chatting.message.service;

import chatting.chatting.message.domain.MessageRoom;
import chatting.chatting.message.service.impl.MessageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    MessageService messageService;
    Map<String, MessageRoom> messageRooms;

    @BeforeEach
    public void beforeEach() {
        messageService = new MessageServiceImpl(new ObjectMapper());
        messageRooms = new LinkedHashMap<>();
    }

    @Test
    void createRoom() throws Exception {
        //given
        String roomId = "roomName";

        //when
        MessageRoom messageRoom = messageService.createRoom("roomName");

        //then
        assertThat(messageRoom.getRoomId()).isEqualTo("roomName");
    }

    @Test
    void findAllRooms() throws Exception {
        //given
        MessageRoom messageRoom1 = messageService.createRoom("roomName");
        MessageRoom messageRoom2 = messageService.createRoom("roomName2");

        System.out.println(messageRooms.toString());


    }
}