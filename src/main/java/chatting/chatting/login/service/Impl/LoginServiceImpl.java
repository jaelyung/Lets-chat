package chatting.chatting.login.service.Impl;

import chatting.chatting.login.service.LoginService;
import chatting.chatting.member.domain.Member;
import chatting.chatting.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MemberMapper memberMapper;

    public Member login(String loginId, String password) {
         return memberMapper.findById(loginId);
    }
}
