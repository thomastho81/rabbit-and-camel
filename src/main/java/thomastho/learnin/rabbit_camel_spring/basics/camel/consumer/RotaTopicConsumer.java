package thomastho.learnin.rabbit_camel_spring.basics.camel.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"camel-topic"})
@Component
public class RotaTopicConsumer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("spring-rabbitmq:topic_01?exchangeType=topic&routingKey=meu.nome.eh.*&queues=topic_queue01")
                .routeId("CONSUMER_TOPIC_1_ROUTE_ID")
                .process(exchange -> {
                    var color = exchange.getIn().getBody(String.class);
                    System.out.println("===== Recebido Topic Queue 01: " + color + " =====  ");
                });

        from("spring-rabbitmq:topic_01?exchangeType=topic&routingKey=meu.nome.#&queues=topic_queue02")
                .routeId("CONSUMER_TOPIC_2_ROUTE_ID")
                .process(exchange -> {
                    var color = exchange.getIn().getBody(String.class);
                    System.out.println("===== Recebido Topic Queue 02: " + color + " =====  ");
                });
    }
}
