package com.cecere.springdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DemoObject")
public class DemoObject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String stringField;
	private Integer integerField;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStringField() {
		return stringField;
	}
	public void setStringField(String stringField) {
		this.stringField = stringField;
	}
	public Integer getIntegerField() {
		return integerField;
	}
	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}
}
