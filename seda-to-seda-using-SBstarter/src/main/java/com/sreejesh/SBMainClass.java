package com.sreejesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import starter.file_to_seda.config.greeting.Hello;

//import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:META-INF/spring/applicationContext.xml") 
public class SBMainClass implements ApplicationRunner {

	@Autowired
	Hello hello;

	public static void main(String[] args) {
		SpringApplication.run(SBMainClass.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("\n\n****** ApplicationRunner has executed!!! *****\n\n");
		hello.sayHello();
	}
}
