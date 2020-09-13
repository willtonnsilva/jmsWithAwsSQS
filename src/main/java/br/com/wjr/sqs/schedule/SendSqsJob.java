package br.com.wjr.sqs.schedule;

import br.com.wjr.sqs.services.SendSqs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@EnableScheduling
@Component
public class SendSqsJob {

    @Autowired
    private SendSqs sendSqs;

    @Value("${consumer.sqs.message.queue.name}")
    private String dentination;

    @Scheduled(fixedRate = 1000 * 10)
    public void send(){
        sendSqs.sendMessage(dentination, "Hello word sqs in " + LocalDateTime.now() + " o'clock");
    }
}
