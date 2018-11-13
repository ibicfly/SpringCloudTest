package io.ibicfly.service0.mq.rabbit;

import io.ibicfly.service0.util.SinaEmailTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test")
public class RabbitReceiver1 {
    @RabbitHandler
    public void receiver1(String msg) {
        String temp="RabbitReceiver1";
        System.out.println("RabbitReceiver1:" + msg);
//        SinaEmailTest.send(temp+msg);
    }
}
