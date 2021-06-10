package com.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@EnableSwagger2
public class EmployeeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringApplication.class, args);
//		log.warn("Application Started");
	}

}
