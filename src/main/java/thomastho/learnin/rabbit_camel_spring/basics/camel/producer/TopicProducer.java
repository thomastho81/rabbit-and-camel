package thomastho.learnin.rabbit_camel_spring.basics.camel.producer;

import org.apache.camel.ProducerTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.basics.ColorMap;

@Profile({"camel-topic"})
@Component
public class TopicProducer {

    private final ProducerTemplate producerTemplate;

    public TopicProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @Scheduled(fixedDelay = 5000)
    public void send() {
        String color = ColorMap.getColor();

        producerTemplate.sendBody("spring-rabbitmq:topic_01?exchangeType=topic&routingKey=meu.nome.eh.thomas", color);
    }
}
