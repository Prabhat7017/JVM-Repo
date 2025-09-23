package org.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PlatformTransactionManager transactionManager (MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }

    @Value("${secret.value}")
    private String secretValue;
    @Bean
    ApplicationRunner runner() {
        return args -> {
            System.out.println("Secret value for Secret 2-> " +secretValue);
        };
    }
}