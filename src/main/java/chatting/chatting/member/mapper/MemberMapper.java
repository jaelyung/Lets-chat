package chatting.chatting.member.mapper;

import chatting.chatting.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    /**
     * 회원등록
     */
    int save(Member member);

    /**
     * 회원조회 - ID
     */
    Member findById(String id);

    /**
     * 회원조회 - NAME
     */
    Member findByName(String name);

    /**
     * 전체회원조회
     */
    List<Member> findAll();

}
