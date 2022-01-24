package chatting.chatting.member.service.Impl;

import chatting.chatting.member.domain.Member;
import chatting.chatting.member.mapper.MemberMapper;
import chatting.chatting.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Transactional
@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 회원가입
     */
    public int join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        int result = memberMapper.save(member);
        return result;
    }

    /**
     * 중복회원검증
     */
    private void validateDuplicateMember(Member member) {
        Member result = memberMapper.findById(member.getMemberId());
        if(result != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberMapper.findAll();
    }

    /**
     * 회원 조회 - ID
     */
    public Member findOne(String memberId) {
        return memberMapper.findById(memberId);
    }
}