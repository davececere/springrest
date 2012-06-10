package com.cecere.springdemo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cecere.springdemo.domain.DemoObject;
import com.cecere.springdemo.repository.DemoObjectRepository;

public class SpringRestDemoServiceImpl implements SpringRestDemoService{
	
	private DemoObjectRepository repository;
	
	public SpringRestDemoServiceImpl(DemoObjectRepository pRepository){
		repository = pRepository;
	}

	@Transactional
	public DemoObject createDemoObject(DemoObject obj) {
		if(obj.getId() != null)
			throw new RuntimeException("new object must not have id property set");
		return repository.save(obj);
	}
	@Transactional
	public DemoObject getDemoObject(Long id) {
		if(id == null)
			throw new RuntimeException("id to fetch must not be null");
		return repository.findOne(id);
	}
	@Transactional
	public DemoObject updateDemoObject(DemoObject obj) {
		if(obj.getId() == null)
			throw new RuntimeException("id for update must not be null");
		return repository.save(obj);
	}
	@Transactional
	public void deleteDemoObject(Long id) {
		repository.delete(id);
	}

	public Iterable<DemoObject> findAll() {
		return repository.findAll();
	}

}
