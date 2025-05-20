package com.fernandosaviogo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernandosaviogo.workshopmongo.domain.User;
import com.fernandosaviogo.workshopmongo.services.UserService;

// Anotações para um rescurso REST
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)    // Pode ser trocado por @GetMapping
	public ResponseEntity<List<User>> findAll() {
	
		List<User> list = service.findAll();    // Busca os usuários no banco e quarda na lista

		return ResponseEntity.ok().body(list);
	}
}
