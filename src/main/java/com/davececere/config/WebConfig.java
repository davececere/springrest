package com.davececere.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.davececere.springdemo.config.ControllerConfig;
import com.davececere.springdemo.config.ServiceConfig;

@EnableWebMvc
@Configuration
@Import({ControllerConfig.class,ServiceConfig.class,RepositoryConfig.class})
@ImportResource( "classpath*:*springDataConfig.xml")
public class WebConfig extends WebMvcConfigurerAdapter {
    
	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	  }
}
