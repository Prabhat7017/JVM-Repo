package com.example.demo;

import com.example.demo.models.AppConfig;
import com.example.demo.models.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan("com.example.demo")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		Car car = SpringApplication.run(DemoApplication.class, args).getBean(Car.class);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Car car = context.getBean(Car.class);
//		System.out.println(car.drive());
	}

}
