package thomastho.learnin.rabbit_camel_spring.puro.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

//    @RabbitListener(queues = "#{}")
//    public void receive(String in) {
//        System.out.println("---- Consumindo mensagem ----");
//
//        System.out.println("Mensagem: " + in);
//
//        System.out.println("---- Mensagem consumida ----");
//    }
}
