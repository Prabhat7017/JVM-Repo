package com.example.demo.config;

import com.example.demo.models.Car;
import com.example.demo.models.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine();
    }

    @Bean
    public Car car(Engine engine) {
        return new Car(engine);
    }
}
