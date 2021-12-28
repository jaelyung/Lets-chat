package chatting.chatting.member.service;

import chatting.chatting.member.domain.Member;
import chatting.chatting.member.mapper.MemberMapper;
import chatting.chatting.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class MemberService {

//    private final MemberRepository memberRepository;
//
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

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

    private void validateDuplicateMember(Member member) {
        memberMapper.findById(member.getId())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
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
    public Optional<Member> findOne(String memberId) {
        return memberMapper.findById(memberId);
    }
}
