package com.fernandosaviogo.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernandosaviogo.workshopmongo.domain.User;
import com.fernandosaviogo.workshopmongo.dto.UserDTO;
import com.fernandosaviogo.workshopmongo.services.UserService;

// Anotações para um rescurso REST
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// Metodo GET
	@RequestMapping(method = RequestMethod.GET) // Pode ser trocado por @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll(); // Busca os usuários no banco e quarda na lista
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Converte cada
																										// obj da lista
																										// para um DTO
		return ResponseEntity.ok().body(listDto);
	}

	// Metodo GET filtrando por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // Pode ser trocado por @GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	// Metodo POST
	@RequestMapping(method = RequestMethod.POST) // Pode ser trocado por @PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Metodo DELETE filtrando por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // Pode ser trocado por @DelteMapping
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// Metodo PUT
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT) // Pode ser trocado por @PuttMapping
		public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
			User obj = service.fromDTO(objDto);
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		}
}
