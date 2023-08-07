package com.example.blogapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BlogappSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogappSpringApplication.class, args);
	}

	@Bean
	@Scope("singleton")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
