package com.generated.project.controller;


import com.generated.project.repository.FilmRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Film;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "film")
public class FilmController {

	@Autowired
	private FilmRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Film film){
	 	return ResponseEntity.ok(repository.save(film));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Film film){
	 	return ResponseEntity.ok(repository.save(film));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Film> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
