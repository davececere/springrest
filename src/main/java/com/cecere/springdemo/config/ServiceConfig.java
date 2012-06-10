package com.cecere.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cecere.springdemo.repository.DemoObjectRepository;
import com.cecere.springdemo.service.SpringRestDemoService;
import com.cecere.springdemo.service.SpringRestDemoServiceImpl;

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
