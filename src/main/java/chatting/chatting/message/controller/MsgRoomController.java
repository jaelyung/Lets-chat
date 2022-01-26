package chatting.chatting.message.controller;

import chatting.chatting.message.domain.MsgRoom;
import chatting.chatting.message.service.MsgService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comm")
public class MsgRoomController {

    private final MsgService msgService;

    @Autowired
    public MsgRoomController(MsgService msgService) {
        this.msgService = msgService;
    }

    @GetMapping("/room")
    public String room(Model model) {
        return "/comm/room";
    }

    @GetMapping("/rooms")
    public List<MsgRoom> rooms() {
        return msgService.findAllRoom();
    }

    @ApiOperation(value = "방 입장", notes = "roomId를 통해서 방에 입장합니다.")
    @GetMapping("/room/enter/{roomId}")
    public String roomEnter(Model model, @ApiParam(value = "방 Id", required = true) @PathVariable String roomId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String loginNm = (String) session.getAttribute("loginNm");

        model.addAttribute("roomId", roomId);
        model.addAttribute("sender", loginNm);

        return "comm/roomEnter";
    }

    @ApiOperation(value = "방 조회", notes = "roomId를 통해서 방을 조회합니다.")
    @GetMapping("/room/{roomId}")
    public MsgRoom roomInfo(@ApiParam(value = "방 Id", required = true) @PathVariable String roomId) {

        return msgService.findByRoomId(roomId);
    }

    @PostMapping("/room")
    @ResponseBody
    public MsgRoom createRoom(@RequestParam String name) {

        return msgService.createMsgRoom(name);
    }

}
