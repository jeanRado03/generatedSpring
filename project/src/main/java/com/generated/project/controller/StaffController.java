package com.generated.project.controller;


import com.generated.project.repository.StaffRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Staff;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "staff")
public class StaffController {

	@Autowired
	private StaffRepository repository;


	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Staff staff){
	 	return ResponseEntity.ok(repository.save(staff));
	}
	@PutMapping()
	public ResponseEntity<Object> update(@RequestBody Staff staff){
	 	return ResponseEntity.ok(repository.save(staff));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
	 	repository.deleteById(id);
		Pagination pagination = new Pagination(repository.findAll(), 1);
		return ResponseEntity.ok(pagination.getPagination());
	}
	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Staff> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}





}
