package thomastho.learnin.rabbit_camel_spring.reliability.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"reliability"})
@Component
public class ConsumerT1 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("spring-rabbitmq:ex-ack01?routingKey=t1&queues=queue-ack01&prefetchCount=1&maximumRetryAttempts=1")
                //asyncConsumer=true&concurrentConsumers=2 -> para consumir 2 mensagens simultaneamente
                //maximumRetryAttempts=2 -> para que o consumer tente 2 vezes antes de dar o ack
                .routeId("CONSUMER_T1_ROUTE_ID")
                .autoStartup(true)
                .unmarshal().json(JsonLibrary.Jackson, String.class)
                .process(exchange -> {
                    System.out.println("----- TO CONSUMINOOO");
                    if (exchange.getMessage().getBody(String.class).equals("t1")) {
                        throw new RuntimeException("Deu erro");
                    }
                    Thread.sleep(10000);
                })
                .log("----- T1 ${body}")
                .end();
    }
}
