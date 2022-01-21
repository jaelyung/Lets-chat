package chatting.chatting.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

//    private final MainService mainService;
//
//    @Autowired
//    public MainController(MainService mainService) {
//        this.mainService = mainService;
//    }

    @GetMapping(value = "/main/newChatRoom")
    public String createNewChatRoom(Model model) {

        model.addAttribute("username", "id1");
        
        return "main/newChatRoom";
    }

}
