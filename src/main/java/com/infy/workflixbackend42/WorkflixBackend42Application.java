package com.infy.workflixbackend42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = { "classpath:messages.properties" })
public class WorkflixBackend42Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkflixBackend42Application.class, args);
	}

}
