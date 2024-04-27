package com.generated.project.controller;


import com.generated.project.repository.StoreRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Store;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "store")
public class StoreController {

	@Autowired
	private StoreRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Store store){
	 	return ResponseEntity.ok(repository.save(store));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Store store){
	 	return ResponseEntity.ok(repository.save(store));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Store> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
