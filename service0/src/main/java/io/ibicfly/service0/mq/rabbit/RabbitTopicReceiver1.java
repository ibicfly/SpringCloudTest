package io.ibicfly.service0.mq.rabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(queues = "topic.message")
public class RabbitTopicReceiver1 {
        @RabbitHandler
        public void process(String msg) {
            String temp=msg;
            System.out.println("RabbitTopicReceiver1 接收器 接受到:" + temp);
        }
}
