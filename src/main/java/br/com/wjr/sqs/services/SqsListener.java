package br.com.wjr.sqs.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SqsListener {

    @JmsListener(destination = "${consumer.sqs.message.queue.name}")
    public void messageConsumer(@Headers Map<String, Object> messageAttributes, @Payload String message) {
        System.out.println("message attibutes " + messageAttributes);
        System.out.println("body " + message);
    }
}
