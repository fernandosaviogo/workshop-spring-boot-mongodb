package com.fernandosaviogo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernandosaviogo.workshopmongo.domain.Post;
import com.fernandosaviogo.workshopmongo.resources.util.URL;
import com.fernandosaviogo.workshopmongo.services.PostService;

// Anotações para um rescurso REST
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	// Metodo GET filtrando por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // Pode ser trocado por @GetMapping
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// Metodo GET filtrando titulo por uma string
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET) // Pode ser trocado por @GetMapping
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
