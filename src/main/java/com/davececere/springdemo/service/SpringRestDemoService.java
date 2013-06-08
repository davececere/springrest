package com.davececere.springdemo.service;

import java.util.List;

import com.davececere.springdemo.domain.DemoObject;

public interface SpringRestDemoService {
	public DemoObject createDemoObject(DemoObject obj);
	public DemoObject getDemoObject(Long id);
	public DemoObject updateDemoObject(DemoObject obj);
	public void deleteDemoObject(Long id);
	public Iterable<DemoObject> findAll();
	public List<DemoObject> findPageResults(int pageNum, int pageSize);
}
