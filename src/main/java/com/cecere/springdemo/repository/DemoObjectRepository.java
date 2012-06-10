package com.cecere.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cecere.springdemo.domain.DemoObject;

public interface DemoObjectRepository extends JpaRepository<DemoObject, Long> {
	
}
