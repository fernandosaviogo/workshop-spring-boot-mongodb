package com.fernandosaviogo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosaviogo.workshopmongo.domain.Post;
import com.fernandosaviogo.workshopmongo.repository.PostRepository;
import com.fernandosaviogo.workshopmongo.services.exception.ObjectNotFoundException;

// Anotação para fazer a classe ser um serviço para injetar em outras classes
@Service
public class PostService {
	
	// Instancia o objeto na classe (injeção de dependencia automatica)
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
		
	public List<Post> findByTitle(String text) {
		// return repo.findByTitleContainingIgnoreCase(text);  // Usando Query Methods
		return repo.searchTitle(text);
	}
}
