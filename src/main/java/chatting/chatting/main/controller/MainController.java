package chatting.chatting.main.controller;

import chatting.chatting.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//    private final MainService mainService;
//
//    @Autowired
//    public MainController(MainService mainService) {
//        this.mainService = mainService;
//    }

    @GetMapping(value = "/main/newChatRoom")
    public String createNewChatRoom() {
        return "main/newChatRoom";
    }

}
