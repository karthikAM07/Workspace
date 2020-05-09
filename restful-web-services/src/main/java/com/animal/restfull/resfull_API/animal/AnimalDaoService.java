package com.animal.restfull.resfull_API.animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AnimalDaoService {

	private static List<Animal> animals = new ArrayList<>();
	private static int AnimalCount=3;
	static {
		animals.add(new Animal(1, "Karthik", ""));
		animals.add(new Animal(2, "Halesh", ""));
		animals.add(new Animal(3, "Kumar", ""));
	}
	
	public List<Animal> findAll(){
		return animals;
	}
	public Animal save(Animal Animal){
		if(Animal.getId()==null){
		Animal.setId(++AnimalCount);
		}
		animals.add(Animal);
		return Animal;
	}
	public Animal findOne(int id){
		for(Animal Animal:animals){
			if(Animal.getId()== id){
				return Animal;
			}
		}
		return null;
	}
	
	public Animal deleteAnimal(int id){
		Iterator <Animal> iterator = animals.iterator();
		while(iterator.hasNext()){
			Animal Animal = iterator.next();
			if(Animal.getId()== id){
				iterator.remove();
				return Animal;
			}
		}
		return null;
	}
}
