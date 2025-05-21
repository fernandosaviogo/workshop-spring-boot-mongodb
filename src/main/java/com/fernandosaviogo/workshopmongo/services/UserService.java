package com.fernandosaviogo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandosaviogo.workshopmongo.domain.User;
import com.fernandosaviogo.workshopmongo.repository.UserRepository;
import com.fernandosaviogo.workshopmongo.services.exception.ObjectNotFoundException;

// Anotação para fazer a classe ser um serviço para injetar em outras classes
@Service
public class UserService {
	
	// Instancia o objeto na classe (injeção de dependencia automatica)
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

}
