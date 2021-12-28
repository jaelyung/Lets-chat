//package chatting.chatting.service;
//
//import chatting.chatting.member.domain.Member;
//import chatting.chatting.member.repository.MemoryMemberReporsitory;
//import chatting.chatting.member.service.MemberService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class MemberServiceTest {
//
//    MemberService memberService;
//    MemoryMemberReporsitory memoryMemberReporsitory;
//
//    @BeforeEach
//    public void beforeEach() {
//        memoryMemberReporsitory = new MemoryMemberReporsitory();
//        memberService = new MemberService(memoryMemberReporsitory);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        memoryMemberReporsitory.clearStore();
//    }
//    @Test
//    void join() throws Exception{
//        //given
//        Member member = new Member();
//        member.setId("id1");
//        member.setPassword("id1");
//        member.setName("김재령");
//
//        //when
//        String saveId = memberService.join(member);
//
//        //then
//        Member findMember = memoryMemberReporsitory.findById(saveId).get();
//        assertEquals(member.getName(), findMember.getName());
//    }
//
//    @Test
//    void 중복_회원_예외() throws Exception {
//        //given
//        Member member1 = new Member();
//        member1.setId("id1");
//        member1.setPassword("id1");
//        member1.setName("김재령");
//
//        Member member2 = new Member();
//        member2.setId("id1");
//        member2.setPassword("id1");
//        member2.setName("김재령");
//
//        //when
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class,
//                () -> memberService.join(member2)); //예외가 발생해야 한다.
//
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//
//}