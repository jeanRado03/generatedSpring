package com.generated.project.controller;


import com.generated.project.repository.CountryRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Country;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "country")
public class CountryController {

	@Autowired
	private CountryRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Country country){
	 	return ResponseEntity.ok(repository.save(country));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Country country){
	 	return ResponseEntity.ok(repository.save(country));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Country> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
