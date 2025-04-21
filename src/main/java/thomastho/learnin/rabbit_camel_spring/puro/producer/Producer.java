package thomastho.learnin.rabbit_camel_spring.puro.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.ColorMap;
import thomastho.learnin.rabbit_camel_spring.Dog;

@Profile({"puro", "puro-producer"})
@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    private final DirectExchange directExchange;

    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    @Scheduled(fixedDelay = 5000)
    public void send() {
        String color = ColorMap.getColor();

        Dog xula = new Dog("Xula", color);

        rabbitTemplate.convertAndSend(directExchange.getName(), color, xula);
        System.out.println("===== Mensagem Enviada: " + xula + " =====  ");
    }

}
