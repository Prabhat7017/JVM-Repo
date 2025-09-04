package org.example.controller;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSMessageController {

    @Autowired
    private SqsTemplate queueMessagingTemplate;

    @Value("${spring.cloud.aws.sqs.endpoint}")
    private String endPoint;

    @GetMapping("/send/{msg}")
    public String sendMessage(@PathVariable String msg) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(msg).build());
        return "Message sent to the queue";
    }

    @SqsListener("sqs-queue")
    public void loadMessageFromQueue(String message) {
        System.out.println("Message received from SQS: " + message);
    }
}
