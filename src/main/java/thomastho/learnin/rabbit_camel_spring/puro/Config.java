package thomastho.learnin.rabbit_camel_spring.puro;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_01", true, false);
    }

//    @Bean
//    public Queue queue01() {
//        return new Queue("queue_01");
//    }

//    @Bean
//    public Queue queue02() {
//        return new Queue("queue_02");
//    }
//
//    @Bean
//    public Queue queue03() {
//        return new Queue("queue_03");
//    }

//    @Bean
//    public Binding binding1(FanoutExchange fanoutExchange, Queue queue01) {
//        return BindingBuilder.bind(queue01).to(fanoutExchange);
//    }

//    @Bean
//    public Binding binding2(FanoutExchange fanoutExchange, Queue queue02) {
//        return BindingBuilder.bind(queue02).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding binding3(FanoutExchange fanoutExchange, Queue queue03) {
//        return BindingBuilder.bind(queue03).to(fanoutExchange);
//    }
}
