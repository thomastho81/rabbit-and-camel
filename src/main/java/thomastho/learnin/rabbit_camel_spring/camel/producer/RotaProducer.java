package thomastho.learnin.rabbit_camel_spring.camel.producer;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import thomastho.learnin.rabbit_camel_spring.ColorMap;
import thomastho.learnin.rabbit_camel_spring.Dog;

@Profile({"camel", "camel-producer"})
@Component
public class RotaProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:send?period=10000")
                .routeId("PRODUCER_ROUTE_ID")
                .autoStartup(true)
                .bean(BeanProducer.class);



        from("timer:send?period=10000")
                .routeId("PRODUCER_DINAMICO_ROUTE_ID")
                .autoStartup(false)
                .process(exchange -> {
                    var color = ColorMap.getColor();
                    exchange.getIn().setBody(new Dog("Xula", color));
                    exchange.getIn().setHeader("color", color);
                })
                .marshal().json(JsonLibrary.Jackson)
                .toD("spring-rabbitmq:direct_01?routingKey=${header.color}")
                .log(LoggingLevel.INFO, "===== Enviando mensagem: ${body}");
    }
}
