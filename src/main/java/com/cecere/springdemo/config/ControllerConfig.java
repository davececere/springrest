package com.cecere.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cecere.springdemo.controller.SpringRestDemoController;

@Configuration
public class ControllerConfig {

	@Bean
	public SpringRestDemoController getSpringRestDemoController(){
		return new SpringRestDemoController();
	}
}
