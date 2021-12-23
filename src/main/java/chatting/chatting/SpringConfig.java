package chatting.chatting;

import chatting.chatting.member.repository.JpaMemberRepository;
import chatting.chatting.member.repository.MemberRepository;
import chatting.chatting.member.repository.MemoryMemberReporsitory;
import chatting.chatting.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberReporsitory();
        return new JpaMemberRepository(em);
    }
}
