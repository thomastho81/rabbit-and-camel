package thomastho.learnin.rabbit_camel_spring.puro.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import thomastho.learnin.rabbit_camel_spring.puro.Dog;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    Map<Integer, String> colorMap = Map.of(1, "Azul", 2, "Preto", 3, "Caramelo");

    @Scheduled(fixedDelay = 5000)
    public void send() throws Exception{
        Random random = new Random();
        int randomColor = random.nextInt(3) + 1;
        String color = colorMap.get(randomColor);
        Dog xula = new Dog("Xula", color);
        //TODO: depois colocar o nome da routingkey as cores

        System.out.println("===== Mensagem : " + xula + " =====  "+ LocalDateTime.now());
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", xula);
    }
}
