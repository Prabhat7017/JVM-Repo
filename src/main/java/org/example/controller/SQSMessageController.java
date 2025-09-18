package org.example.controller;
import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SQSMessageController {

    @Autowired
    private SqsTemplate queueMessagingTemplate;

    private RedisTemplate<String, String> redisTemplate;
    private HashOperations hashOperations;

    public SQSMessageController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }
    @Value("${spring.cloud.aws.sqs.endpoint}")
    private String endPoint;

    @GetMapping("/send/{msg}")
    public String sendMessage(@PathVariable String msg) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(msg).build());
        return "Message sent to the queue";
    }

    @GetMapping("/all")
    public Map<String, String> getAllMessages() {
        return hashOperations.entries("redissqstestingcache");
    }
    @SqsListener("sqs-queue")
    public void loadMessageFromQueue(String message) {
        System.out.println("Message received from SQS: " + message);
        hashOperations.put("redissqstestingcache", message + "123", message);
        System.out.println("Message saved to Redis: " + message);
    }
}
