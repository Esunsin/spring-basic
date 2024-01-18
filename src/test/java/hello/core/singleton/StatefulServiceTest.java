package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //threadA : 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //threadB : 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        org.assertj.core.api.Assertions.assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}