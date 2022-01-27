package chatting.chatting.login.mapper;

import chatting.chatting.login.domain.LoginForm;
import chatting.chatting.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    Member memberLogin(LoginForm form);
}
