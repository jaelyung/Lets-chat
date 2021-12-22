package chatting.chatting.member.repository;

import chatting.chatting.member.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberReporsitoryTest {

    MemoryMemberReporsitory reporsitory = new MemoryMemberReporsitory();

    @AfterEach
    public void afterEach() {
        reporsitory.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member();
        member.setId("id1");
        member.setPassword("id1");
        member.setName("김재령");

        //when
        reporsitory.save(member);

        //then
        Member result = reporsitory.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {
        //given
        Member member1 = new Member();
        member1.setId("id1");
        member1.setPassword("id1");
        member1.setName("김재령");
        reporsitory.save(member1);

        Member member2 = new Member();
        member2.setId("id2");
        member2.setPassword("id2");
        member2.setName("김재령");
        reporsitory.save(member2);

        //when
        Member result = reporsitory.findById("id1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findByName() {
        //given
        Member member1 = new Member();
        member1.setId("id1");
        member1.setPassword("id1");
        member1.setName("김재령");
        reporsitory.save(member1);

        Member member2 = new Member();
        member2.setId("id2");
        member2.setPassword("id2");
        member2.setName("김재령2");
        reporsitory.save(member2);

        //when
        Member result = reporsitory.findByName("김재령2").get();

        //then
        assertThat(result).isEqualTo(member2);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setId("id1");
        member1.setPassword("id1");
        member1.setName("김재령");
        reporsitory.save(member1);

        Member member2 = new Member();
        member2.setId("id2");
        member2.setPassword("id2");
        member2.setName("김재령2");
        reporsitory.save(member2);

        //when
        List<Member> result = reporsitory.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);

    }
}