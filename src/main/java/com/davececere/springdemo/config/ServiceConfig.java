package com.davececere.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.davececere.springdemo.repository.DemoObjectRepository;
import com.davececere.springdemo.service.SpringRestDemoService;
import com.davececere.springdemo.service.SpringRestDemoServiceImpl;

@Configuration
@EnableTransactionManagement
public class ServiceConfig {
	
	//dependencies from other config
	@Autowired 
	private DemoObjectRepository repository;
	
	@Bean
	public SpringRestDemoService getSpringRestDemoService(){
		return new SpringRestDemoServiceImpl(repository);
	}
}
