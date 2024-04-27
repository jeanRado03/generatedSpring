package com.generated.project.controller;


import com.generated.project.repository.CityRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.City;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "city")
public class CityController {

	@Autowired
	private CityRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody City city){
	 	return ResponseEntity.ok(repository.save(city));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody City city){
	 	return ResponseEntity.ok(repository.save(city));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<City> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
