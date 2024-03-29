package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    @Test
    public void join () throws Exception{
        //give
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
