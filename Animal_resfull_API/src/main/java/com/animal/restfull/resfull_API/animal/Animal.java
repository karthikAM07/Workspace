package com.animal.restfull.resfull_API.animal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Animal {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="min have 2 char")
	private String name;
	private String language;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", language=" + language + "]";
	}
	public Animal(Integer id, String name, String language) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
	}
	public Animal() {
		
	}
	
}
