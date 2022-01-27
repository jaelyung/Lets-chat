package chatting.chatting.member.service;

import chatting.chatting.member.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    int join(Member member);

    List<Member> findMembers();
}
