package io.ibicfly.service0.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**@Configuration
 *
 *
 */
public class RabbitMqConfig {
    @Value("${mq.rabbit.host}")
    private String mqRabbitHost;
    @Value("${mq.rabbit.port}")
    private String mqRabbitPort;
    @Value("${mq.rabbit.username}")
    private String mqRabbitUserName;
    @Value("${mq.rabbit.password}")
    private String mqRabbitPassword;
    @Value("${mq.rabbit.virtualHost}")
    private String mqRabbitVirtualHost;
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.mqRabbitHost,Integer.parseInt(mqRabbitPort));

        connectionFactory.setUsername(this.mqRabbitUserName);
        connectionFactory.setPassword(this.mqRabbitPassword);
        connectionFactory.setVirtualHost(this.mqRabbitVirtualHost);
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;

    }
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        return template;
//    }
//    @Bean
//    public DirectExchange defaultExchange() {
//        return new DirectExchange(EXCHANGE_NAME);
//    }
    @Bean
    public Queue Queue1() {
        return new Queue("test");
    }


//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue()).to(defaultExchange()).with(ROUTING_KEY);
//    }

//    public static void main(String[] args) {
//        ConnectionUtil
//    }
}
