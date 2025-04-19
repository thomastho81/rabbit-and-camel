package thomastho.learnin.rabbit_camel_spring.puro.producer;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.puro.Dog;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

@Profile("puro")
@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;


    private final DirectExchange directExchange;

    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    Map<Integer, String> colorMap = Map.of(1, "Azul", 2, "Preto", 3, "Caramelo");

    @Scheduled(fixedDelay = 5000)
    public void send() {
        Random random = new Random();
        int randomColor = random.nextInt(3) + 1;
        String color = colorMap.get(randomColor);
        Dog xula = new Dog("Xula", color);

        rabbitTemplate.convertAndSend(directExchange.getName(), color, xula);
        System.out.println("===== Mensagem Enviada: " + xula + " =====  " + LocalDateTime.now());
    }
}
