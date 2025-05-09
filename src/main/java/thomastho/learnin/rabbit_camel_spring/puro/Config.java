package thomastho.learnin.rabbit_camel_spring.puro;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"puro", "puro-producer", "puro-consumer"})
@Configuration
public class Config {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_01");
    }

    @Bean
    public Queue dogQueue() {
        return new Queue("dog_queue");
    }

    @Bean
    public Binding bindingDirectAzul(DirectExchange directExchange, Queue queue01) {
        return BindingBuilder.bind(queue01).to(directExchange).with("Azul");
    }

    @Bean
    public Binding bindingDirectCaramelo(DirectExchange directExchange, Queue dogQueue) {
        return BindingBuilder.bind(dogQueue).to(directExchange).with("Caramelo");
    }

}
