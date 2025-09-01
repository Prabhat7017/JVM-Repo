package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
