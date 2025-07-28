package thomastho.learnin.rabbit_camel_spring.reliability.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import thomastho.learnin.rabbit_camel_spring.reliability.PilotoDTO;

public class ConsumerPuroT1 {

    @RabbitListener(queues = "piloto.queue")
    public void consumir(@Payload PilotoDTO dto, Channel channel) {
        System.out.println(dto);
        //channel.basicAck();
    }

}
