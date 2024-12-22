package com.springboot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.jdbc.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootWithJdbcApplication {

	public static void main(String[] args) {
				SpringApplication.run(SpringbootWithJdbcApplication.class, args);
		
	}
}
