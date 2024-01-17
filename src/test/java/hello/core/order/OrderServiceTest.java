package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());


    @Test
    public void createOrder () throws Exception{
        //give
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(order.getItemPrice()).isEqualTo(10000);

    }


}
