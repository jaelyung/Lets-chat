package chatting.chatting.login.service;

import chatting.chatting.member.domain.Member;

public interface LoginService {

    Member login(String loginId, String password);
}
