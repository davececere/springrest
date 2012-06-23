package com.cecere.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cecere.springdemo.domain.DemoObject;

public interface DemoObjectRepository extends JpaRepository<DemoObject, Long> {
	@Transactional
	List<DemoObject> findByStringFieldAndIntegerField(String string, Integer integer);
	
	@Transactional
	@Query("select d from DemoObject d where d.stringField = :stringField and d.integerField = :integerField")
	List<DemoObject> findByCustomQuery(@Param("stringField") String stringField,@Param("integerField") Integer integerField);

	@Transactional(readOnly=false)
	@Modifying(clearAutomatically=false)
	@Query("update DemoObject d set d.stringField = :stringField where d.id = :id")
	int setStringFieldForId(@Param("stringField") String stringField, @Param("id") Long id);
}
