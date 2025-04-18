package thomastho.learnin.rabbit_camel_spring.puro;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thomastho.learnin.rabbit_camel_spring.puro.producer.Producer;

@Configuration
public class Config {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_01");
    }

    @Bean
    public Queue queue01() {
        return new Queue("queue_01");
    }


    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue queue01) {
        return BindingBuilder.bind(queue01).to(fanoutExchange);
    }

    @Bean
    public Producer producer() {
        return new Producer();
    }

}
