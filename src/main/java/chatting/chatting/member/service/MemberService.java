package chatting.chatting.member.service;

import chatting.chatting.member.domain.Member;

import java.util.List;

public interface MemberService {

    int join(Member member);

    List<Member> findMembers();
}
