package chatting.chatting.login.service;

import chatting.chatting.member.domain.Member;
import chatting.chatting.member.mapper.MemberMapper;
import chatting.chatting.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    //private final MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;

//    public LoginService(MemberRepository memberRepository) {
//        this.memberMapper = memberRepository;
//    }

    public Member login(String loginId, String password) {
         return memberMapper.findById(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
