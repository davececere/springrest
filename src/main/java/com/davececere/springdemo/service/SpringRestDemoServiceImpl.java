package com.davececere.springdemo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.davececere.springdemo.domain.DemoObject;
import com.davececere.springdemo.repository.DemoObjectRepository;

public class SpringRestDemoServiceImpl implements SpringRestDemoService{
	
	private DemoObjectRepository repository;
	
	public SpringRestDemoServiceImpl(DemoObjectRepository pRepository){
		repository = pRepository;
	}

	@Override
	@Transactional
	public DemoObject createDemoObject(DemoObject obj) {
		if(obj.getId() != null)
			throw new RuntimeException("new object must not have id property set");
		return repository.save(obj);
	}
	@Override
	@Transactional
	public DemoObject getDemoObject(Long id) {
		if(id == null)
			throw new RuntimeException("id to fetch must not be null");
		return repository.findOne(id);
	}
	@Override
	@Transactional
	public DemoObject updateDemoObject(DemoObject obj) {
		if(obj.getId() == null)
			throw new RuntimeException("id for update must not be null");
		DemoObject pObj = repository.findOne(obj.getId());
		pObj.setIntegerField(obj.getIntegerField());
		pObj.setStringField(obj.getStringField());
		return repository.save(pObj);
	}

	@Override
	@Transactional
	public void deleteDemoObject(Long id) {
		repository.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<DemoObject> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DemoObject> findPageResults(int pageNum, int pageSize) {
		Sort sort = new Sort(Direction.ASC,"integerField"); //assumed sort for now
		Pageable pageable = new PageRequest(pageNum,pageSize, sort);
		Page<DemoObject> page = repository.findAll(pageable);
		return page.getContent();
	}
}
