package com.animal.restfull.resfull_API.animal;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.animal.restfull.resfull_API.animal.animalNotFoundException;

@RestController
public class AnimalResource {
    
	@Autowired
	AnimalDaoService service;
	
	//retriveAllAnimals
	//GET /animals
	@GetMapping("/animals")
	public List<Animal> retriveAllAnimal(){
		return service.findAll();
	}
	
	//retriveSingleAnimal
	@GetMapping("/animals/{id}")
	public Animal findAnimal(@PathVariable int id){
		Animal animal = service.findOne(id);
		
		if (animal==null) throw new animalNotFoundException("id-"+id);
		
		org.springframework.hateoas.Resource<Animal> resource 
		= new org.springframework.hateoas.Resource<Animal>(animal);
		
	//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()),retriveAllAnimal());
		return animal;
	}
	
	//creating Animal
	//POST/animal
	@PostMapping("/animal")
	public ResponseEntity<Object> createAnimal(@Valid @RequestBody Animal animal){
		Animal savedAnimal = service.save(animal);
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedAnimal.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//delete animal using by id
	@DeleteMapping("/animals/{id}")
	public Animal deleteAnimal(@PathVariable int id){
		Animal animal = service.deleteAnimal(id);
		if (animal==null) throw new animalNotFoundException("id-"+id);
		return animal; 
	}
}
