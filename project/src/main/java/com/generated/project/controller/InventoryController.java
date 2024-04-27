package com.generated.project.controller;


import com.generated.project.repository.InventoryRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Inventory;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "inventory")
public class InventoryController {

	@Autowired
	private InventoryRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Inventory inventory){
	 	return ResponseEntity.ok(repository.save(inventory));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Inventory inventory){
	 	return ResponseEntity.ok(repository.save(inventory));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Inventory> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
