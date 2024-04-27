package com.generated.project.controller;


import com.generated.project.repository.UtilisateurRepository;
import com.generated.project.pagination.*;
import com.generated.project.entity.Utilisateur;
import com.generated.project.security.AuthenticationRequest;
import com.generated.project.security.AuthenticationResponse;
import com.generated.project.security.AuthenticationService;
import com.generated.project.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RequiredArgsConstructor
@RequestMapping(path = "/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurRepository repository;
	private final AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody RegisterRequest request) {
		AuthenticationResponse authenticationResponse=null;
		HashMap<String,Object> response=new HashMap<>();

		try
		{
			authenticationResponse =  authenticationService.register(request);
			response.put("status",200);
			response.put("token",authenticationResponse.getToken());
			response.put("id_user", authenticationResponse.getUser().getId_user());
			//return ResponseEntity.ok(authenticationResponse);

		}catch (Exception e){
			response.put("erreur",e.getMessage());
		}
		finally {
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/authenticate")
	public ResponseEntity<Object> register(@RequestBody AuthenticationRequest request) {
		//AuthenticationResponse authenticationResponse=authenticationService.authenticate(request);
		AuthenticationResponse authenticationResponse=null;
		HashMap<String,Object> response=new HashMap<>();
		try
		{
			authenticationResponse =  authenticationService.authenticate(request);
			response.put("status",200);
			response.put("token",authenticationResponse.getToken());
			response.put("id_user", authenticationResponse.getUser().getId_user());

		}catch (Exception e){
			response.put("erreur",e.getMessage());
		}
		finally {
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/{page}")
	public ResponseEntity<Object> findAll(@PathVariable int page){
	 	Iterable<Utilisateur> data = repository.findAll();
		Pagination pagination = new Pagination(data,page);
		return ResponseEntity.ok(pagination.getPagination());
	}

	@DeleteMapping("/{iduser}")
	public ResponseEntity<Object> delete(@PathVariable String iduser){
		authenticationService.logOut(iduser);
		HashMap<String,Object> response=new HashMap<>();
		response.put("status",200);
		return ResponseEntity.ok(response);
	}
}
