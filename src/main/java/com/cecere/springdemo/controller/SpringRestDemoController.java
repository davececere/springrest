package com.cecere.springdemo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecere.springdemo.domain.DemoObject;

@Controller
public class SpringRestDemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringRestDemoController.class);
	
	@RequestMapping(value = "/demo/{id}", 
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public @ResponseBody DemoObject getDemoById(Locale locale,@PathVariable Long id) {
		//logger.info("Welcome home! the client locale is "+ locale.toString());
		DemoObject obj = new DemoObject();
		obj.setId(id);
		obj.setStringField("string value");
		obj.setIntegerField(1234);
		return obj;
	}
	
}
