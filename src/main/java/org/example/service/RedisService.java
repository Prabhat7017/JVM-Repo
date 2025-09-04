package org.example.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setRedit(String key, User user, Long ttl){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); //Mapper can not find Java 8 date time module so register it
            String userJson = mapper.writeValueAsString(user);
            redisTemplate.opsForValue().set(key, userJson, ttl, TimeUnit.SECONDS);
            System.out.println("\n\n\nUser set in Redis with key: " + key);
        }catch (Exception e){
            System.out.println("Error setting value in Redis: " + e.getMessage());
        }

    }

    public User getRedit(String key){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            // Ignore unknown properties during deserialization as id will have two fields date and timestamp which are not in User class
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Object o = redisTemplate.opsForValue().get(key);
            if (o == null) return null;
            System.out.println("\n\n\nUser retrieved from Redis with key: " + key);
            return mapper.readValue(o.toString(), User.class);
        }catch (Exception e){
            System.out.println("Error getting value from Redis: " + e.getMessage());
            return null;
        }
    }
}
