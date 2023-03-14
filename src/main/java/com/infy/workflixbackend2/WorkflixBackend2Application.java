package com.infy.workflixbackend2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:messages.properties" })
public class WorkflixBackend2Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkflixBackend2Application.class, args);
	}

}
