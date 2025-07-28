package thomastho.learnin.rabbit_camel_spring.basics.camel.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.basics.ColorMap;
import thomastho.learnin.rabbit_camel_spring.basics.Dog;

@Component
public class BeanProducer {

    private final ProducerTemplate producerTemplate;

    public BeanProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void send() throws JsonProcessingException {
        String color = ColorMap.getColor();
        Dog xula = new Dog("Xula", color);
        ObjectMapper objectMapper = new ObjectMapper();

        producerTemplate.sendBody("spring-rabbitmq:direct_01?routingKey=" + color, objectMapper.writeValueAsString(xula));

        System.out.println("===== Enviando mensagem: " + xula + " =====  ");
    }
}
