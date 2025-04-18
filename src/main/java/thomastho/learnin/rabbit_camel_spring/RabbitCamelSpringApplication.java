package thomastho.learnin.rabbit_camel_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitCamelSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitCamelSpringApplication.class, args);
	}

}
