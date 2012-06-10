package com.cecere.springdemo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.cecere.springdemo.config.ControllerConfig;
import com.cecere.springdemo.config.RepositoryConfig;
import com.cecere.springdemo.config.ServiceConfig;
import com.cecere.springdemo.domain.DemoObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class,RepositoryConfig.class,ServiceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class DemoObjectControllerIT extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private SpringRestDemoController controller;

	@Test
	public void testCRUDWorkflow(){
		
		DemoObject newObject = new DemoObject();
		newObject.setIntegerField(2);
		newObject.setStringField("stringfield");
		
		//create
		DemoObject ret = controller.createDemoObject(null, newObject);
		assertNotNull(ret);
		assertNotNull(ret.getId());
		
		//list
		Iterable<DemoObject> list = controller.getAllDemoObjects(null);
		assertNotNull(list);
		assertTrue(list.iterator().hasNext());
		
		//read
		ret = controller.getDemoById(null, ret.getId());
		assertNotNull(ret);
		assertNotNull(ret.getId());
		
		//update
		ret.setIntegerField(3);
		ret = controller.updateDemoObject(null, ret, ret.getId());
		assertEquals(3,ret.getIntegerField().intValue());
		
		//delete
		controller.deleteDemoObject(null, ret.getId());
		ret = controller.getDemoById(null, ret.getId());
		assertNull(ret);
	}
	
	
}
