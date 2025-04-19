package thomastho.learnin.rabbit_camel_spring.puro.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.puro.Dog;

@Profile("puro")
@Component
public class Consumer {

    @RabbitListener(queues = "dog_queue")
    public void receive(Message<Dog> in) {
        System.out.println("----- Mensagem Recebida: " + in.getPayload() + " -----");
    }

}
