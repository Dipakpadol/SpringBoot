package com.firstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	
		SpringApplication.run(Application.class, args);
		
		String message = hello();
		System.out.println(message);

	}
	
	public static String hello() {
		return "Hello World I'm Coming!";
	}

}
