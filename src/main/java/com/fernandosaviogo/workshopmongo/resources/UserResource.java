package com.fernandosaviogo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernandosaviogo.workshopmongo.domain.User;
import com.fernandosaviogo.workshopmongo.dto.UserDTO;
import com.fernandosaviogo.workshopmongo.services.UserService;

// Anotações para um rescurso REST
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)    // Pode ser trocado por @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
	
		List<User> list = service.findAll();    // Busca os usuários no banco e quarda na lista
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Converte cada obj da lista para um DTO
		return ResponseEntity.ok().body(listDto);
	}
}
