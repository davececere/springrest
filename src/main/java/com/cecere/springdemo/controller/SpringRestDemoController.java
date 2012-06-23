package com.cecere.springdemo.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cecere.springdemo.domain.DemoObject;
import com.cecere.springdemo.service.SpringRestDemoService;

@Controller
public class SpringRestDemoController {
	
	private SpringRestDemoService service;
	private static final Logger logger = LoggerFactory.getLogger(SpringRestDemoController.class);
	
	public SpringRestDemoController(SpringRestDemoService pService){
		service = pService;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(
			value = "/demo/{id}", 
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public @ResponseBody DemoObject getDemoById(Locale locale,@PathVariable Long id) {
		return service.getDemoObject(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(
			value = "/demo", 
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public @ResponseBody List<DemoObject> getPageDemoObjects(Locale locale,@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
		return service.findPageResults(pageNum, pageSize);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(
			value = "/demo", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public @ResponseBody DemoObject createDemoObject(Locale locale,@RequestBody DemoObject newObj) {
		return service.createDemoObject(newObj);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(
			value = "/demo/{id}", 
			method = RequestMethod.PUT,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public @ResponseBody DemoObject updateDemoObject(Locale locale,@RequestBody DemoObject newObj,@PathVariable Long id) {
		if(newObj.getId() == null || newObj.getId() != id)
			throw new RuntimeException("id of incoming object must match path id for update");
		return service.updateDemoObject(newObj);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(
			value = "/demo/{id}", 
			method = RequestMethod.DELETE
	)
	public void deleteDemoObject(Locale locale,@PathVariable Long id) {
		service.deleteDemoObject(id);
	}
	
}
