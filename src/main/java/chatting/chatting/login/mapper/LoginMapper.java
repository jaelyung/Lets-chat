package chatting.chatting.login.mapper;

import chatting.chatting.member.domain.Member;

public interface LoginMapper {

    Member memberLogin(String loginId, String password);
}
