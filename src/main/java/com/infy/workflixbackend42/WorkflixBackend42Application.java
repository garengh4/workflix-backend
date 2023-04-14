package com.infy.workflixbackend42;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = { "classpath:messages.properties" })
@OpenAPIDefinition(info = @Info(
		title = "Workflix API",
		version = "0.0",
		description = "Should break workflix into microservice: loginService, gcpFileService, blogService, chatGTPService"
))
public class WorkflixBackend42Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkflixBackend42Application.class, args);
	}

}
