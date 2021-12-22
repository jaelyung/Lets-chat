package chatting.chatting;

import chatting.chatting.member.repository.MemberRepository;
import chatting.chatting.member.repository.MemoryMemberReporsitory;
import chatting.chatting.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberReporsitory();
    }
}
