package com.nare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.nare")
public class P2RestExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2RestExceptionHandlingApplication.class, args);
	}

}
