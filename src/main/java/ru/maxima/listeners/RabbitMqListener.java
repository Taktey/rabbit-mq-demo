package ru.maxima.listeners;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabbitMqListener {
    @RabbitListener(queues="myFirstQueue")
    public void processMsg(String msg){
        System.out.println("Received msg from myFirstQueue : "+ new String(msg));
    }
}
