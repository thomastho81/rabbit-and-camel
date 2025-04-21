package thomastho.learnin.rabbit_camel_spring.camel.consumer;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.Dog;

@Profile({"camel", "camel-consumer"})
@Component
public class RotaConsumer extends RouteBuilder {

    private static final String CARAMELO = "Caramelo";
    private static final String AZUL = "Azul";
    @Override
    public void configure() throws Exception {

        from("spring-rabbitmq:direct_01?routingKey=" + CARAMELO + "&queues=dog_queue&arg.queue.durable=true")
                .routeId("CONSUMER_CARAMELO_ROUTE_ID")
                .autoStartup(true)
                .unmarshal().json(JsonLibrary.Jackson, Dog.class)
                .log(LoggingLevel.INFO, "---- Recebido: ${body}");

        from("spring-rabbitmq:direct_01?routingKey=" + AZUL + "&queues=dog_queue&arg.queue.durable=true")
                .routeId("CONSUMER_AZUL_ROUTE_ID")
                .autoStartup(true)
                .unmarshal().json(JsonLibrary.Jackson, Dog.class)
                .log(LoggingLevel.INFO, "---- Recebido: ${body}");


    }
}
