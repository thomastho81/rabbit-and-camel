package thomastho.learnin.rabbit_camel_spring.puro.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.puro.Dog;

@Component
public class Consumer {


    @RabbitListener(queues = "queue_01")
    public void receive(Message<Dog> in) {
        System.out.println("Mensagem recebida ===== " + in.getPayload());
    }


}
