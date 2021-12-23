package chatting.chatting.member.repository;

import chatting.chatting.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    /**
     * 회원등록
     */
    Member save(Member member);

    /**
     * 회원조회 - ID
     */
    Optional<Member> findById(String id);

    /**
     * 회원조회 - NAME
     */
    Optional<Member> findByName(String name);

    /**
     * 전체회원조회
     */
    List<Member> findAll();

}
