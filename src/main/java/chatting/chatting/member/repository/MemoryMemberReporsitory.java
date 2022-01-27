package chatting.chatting.member.repository;

import chatting.chatting.member.domain.Member;

import java.util.*;

public class MemoryMemberReporsitory implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    /**
     * 회원등록
     */
    @Override
    public Member save(Member member) {
        store.put(member.getMemberId(), member);
        return member;
    }

    /**
     * 회원조회 - ID
     */
    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * 회원조회 - NAME
     */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getMemberNm().equals(name))
                .findAny();
    }

    /**
     * 전체회원조회
     */
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * store 초기화
     */
    public void clearStore() {
        store.clear();
    }
}
