package com.cecere.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cecere.springdemo.controller.SpringAsyncWebServiceProxyController;
import com.cecere.springdemo.controller.SpringRestDemoController;
import com.cecere.springdemo.service.SpringRestDemoService;
import com.ning.http.client.AsyncHttpClient;

@Configuration
public class ControllerConfig {
    //dependencies from other configurations
    @Autowired
    private SpringRestDemoService springRestDemoService;

    @Bean
    public SpringRestDemoController getSpringRestDemoController(){
        return new SpringRestDemoController(springRestDemoService);
    }

    @Bean
    public SpringAsyncWebServiceProxyController getSpringAsyncWebServiceProxyController(){
        SpringAsyncWebServiceProxyController c =  new SpringAsyncWebServiceProxyController();
        c.setAsyncHttpClient(getAsyncHttpClient());
        return c;
    }

    @Bean
    public AsyncHttpClient getAsyncHttpClient(){
        return new AsyncHttpClient();
    }
}
