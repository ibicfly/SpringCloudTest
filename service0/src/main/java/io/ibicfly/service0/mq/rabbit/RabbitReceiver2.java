package io.ibicfly.service0.mq.rabbit;

import io.ibicfly.service0.util.SinaEmailTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test")
public class RabbitReceiver2 {
    @RabbitHandler
    public void receiver1(String msg) {
        String temp="RabbitReceiver2";
        System.out.println("RabbitReceiver2:" + msg);
//        SinaEmailTest.send(temp+msg);
    }
}