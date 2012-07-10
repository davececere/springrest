package com.cecere.springdemo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.cecere.config.RepositoryConfig;
import com.cecere.springdemo.config.ControllerConfig;
import com.cecere.springdemo.config.ServiceConfig;
import com.cecere.springdemo.domain.DemoObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class,RepositoryConfig.class,ServiceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class DemoObjectRepositoryIT extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private DemoObjectRepository repository;
	
	//just run some tests on my own defined methods
	@Test
	public void testFindByStringAndInteger(){
		DemoObject object = new DemoObject();
		object.setIntegerField(1);
		object.setStringField("string1");
		repository.save(object);
		
		//should exist
		List<DemoObject> ret = repository.findByStringFieldAndIntegerField("string1", 1);
		assertEquals(1,ret.size());
		
		//shouldn't exist
		ret = repository.findByStringFieldAndIntegerField("string2", 1);
		assertTrue(ret.isEmpty());
	}
	
	@Test
	public void testFindByCustomQuery(){
		DemoObject object = new DemoObject();
		object.setIntegerField(1);
		object.setStringField("string1");
		repository.save(object);
		
		//should exist
		List<DemoObject> ret = repository.findByCustomQuery("string1", 1);
		assertEquals(1,ret.size());
		
		//shouldn't exist
		ret = repository.findByCustomQuery("string2", 1);
		assertTrue(ret.isEmpty());
	}
	
	@Test
	public void testSetStringFieldForId(){
		DemoObject object = new DemoObject();
		object.setIntegerField(3);
		object.setStringField("string1");
		repository.save(object);
		
		int rows = repository.setStringFieldForId("string2updated", object.getId());
		repository.flush();
		
		//one row
		assertEquals(1,rows);
	}
}
