package chatting.chatting.login.service.Impl;

import chatting.chatting.login.domain.LoginForm;
import chatting.chatting.login.mapper.LoginMapper;
import chatting.chatting.login.service.LoginService;
import chatting.chatting.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Member login(LoginForm form) {
         return loginMapper.memberLogin(form);
    }
}
