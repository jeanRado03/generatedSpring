package com.generated.project.controller;


import com.generated.project.repository.AddressRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Address;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "address")
public class AddressController {

	@Autowired
	private AddressRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Address address){
	 	return ResponseEntity.ok(repository.save(address));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Address address){
	 	return ResponseEntity.ok(repository.save(address));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Address> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
