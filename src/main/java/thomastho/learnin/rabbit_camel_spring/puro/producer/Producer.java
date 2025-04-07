package thomastho.learnin.rabbit_camel_spring.puro.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    public void send() {
        String message = "E ai meu parceiro";
        rabbitTemplate.convertAndSend(fanoutExchange.getType(), "", message);
    }
}
