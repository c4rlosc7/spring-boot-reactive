package com.springboot.reactive.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReactiveApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootReactiveApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveApplication.class, args);
		logger.info("Initializing application...");
	}
}
