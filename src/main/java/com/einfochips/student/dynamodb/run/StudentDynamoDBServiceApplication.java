package com.einfochips.student.dynamodb.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = { "com.einfochips.student.dynamodb" })
public class StudentDynamoDBServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudentDynamoDBServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentDynamoDBServiceApplication.class);
	}

}
