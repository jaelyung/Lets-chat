package chatting.chatting.login.service;

import chatting.chatting.login.domain.LoginForm;
import chatting.chatting.member.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Member login(LoginForm form);
}
