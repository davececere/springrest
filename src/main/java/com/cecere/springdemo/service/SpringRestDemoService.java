package com.cecere.springdemo.service;

import java.util.List;

import com.cecere.springdemo.domain.DemoObject;

public interface SpringRestDemoService {
	public DemoObject createDemoObject(DemoObject obj);
	public DemoObject getDemoObject(Long id);
	public DemoObject updateDemoObject(DemoObject obj);
	public void deleteDemoObject(Long id);
	public Iterable<DemoObject> findAll();
}
