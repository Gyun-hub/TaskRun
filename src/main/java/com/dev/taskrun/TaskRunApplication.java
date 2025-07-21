package com.dev.taskrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TaskRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskRunApplication.class, args);
	}

}
