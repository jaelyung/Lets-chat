package chatting.chatting.login.service;

import chatting.chatting.login.domain.LoginForm;
import chatting.chatting.member.domain.Member;

public interface LoginService {

    Member login(LoginForm form);
}
