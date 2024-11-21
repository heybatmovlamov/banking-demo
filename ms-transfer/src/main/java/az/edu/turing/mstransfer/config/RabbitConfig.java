package az.edu.turing.mstransfer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue otpQueue() {
        return new Queue("otpQueue", false);
    }

    @Bean
    public Queue transferQueue() {
        return new Queue("transferQueue", false);
    }
}
