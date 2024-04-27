package com.generated.project.controller;


import com.generated.project.repository.LanguageRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Language;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "language")
public class LanguageController {

	@Autowired
	private LanguageRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Language language){
	 	return ResponseEntity.ok(repository.save(language));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Language language){
	 	return ResponseEntity.ok(repository.save(language));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Language> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
